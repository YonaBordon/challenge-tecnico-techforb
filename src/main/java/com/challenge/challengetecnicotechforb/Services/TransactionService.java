package com.challenge.challengetecnicotechforb.Services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.challenge.challengetecnicotechforb.Entities.Account;
import com.challenge.challengetecnicotechforb.Entities.Transaction;
import com.challenge.challengetecnicotechforb.Entities.Dto.TransactionResponseDTO;
import com.challenge.challengetecnicotechforb.Exception.AccessDeniedException;
import com.challenge.challengetecnicotechforb.Exception.BadRequestException;
import com.challenge.challengetecnicotechforb.Mappers.TransactionMapper;
import com.challenge.challengetecnicotechforb.Repositories.TransactionRepository;

@Service
public class TransactionService {
  private TransactionRepository transactionRepository;
  private AccountService accountService;

  public TransactionService(TransactionRepository transactionRepository, AccountService accountService) {
    this.transactionRepository = transactionRepository;
    this.accountService = accountService;
  }

  public TransactionResponseDTO createTransaction(String token, String destinationAccountId, BigDecimal amount,
      String description) {

    Account origin = accountService.getAccountFromToken(token);

    if (origin == null) {
      throw new AccessDeniedException("Token venciado o inválido.");
    }

    if (origin.getBalance().compareTo(amount) < 0) {
      throw new BadRequestException("El monto a transferir es mayor al saldo disponible.");
    }

    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("El monto a transferir debe ser mayor a 0.");
    }

    if (destinationAccountId == null || destinationAccountId.isEmpty()) {
      throw new IllegalArgumentException("La cuenta de destino no puede estar vacía.");
    }

    Account destinationAccount = accountService.getAccountById(destinationAccountId);

    Transaction transaction = new Transaction();
    transaction.setAccount(origin);
    transaction.setAmount(amount);
    transaction.setDate(LocalDate.now());
    transaction.setDescription(description);
    transaction.setDestinationAccount(destinationAccount);

    origin.setBalance(origin.getBalance().subtract(amount));
    destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

    accountService.save(origin);
    accountService.save(destinationAccount);
    transactionRepository.save(transaction);

    return TransactionMapper.toTransactionResponseDTO(transaction);
  }

}
