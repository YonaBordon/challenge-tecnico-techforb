package com.challenge.challengetecnicotechforb.Services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.challengetecnicotechforb.Entities.Account;
import com.challenge.challengetecnicotechforb.Entities.Transaction;
import com.challenge.challengetecnicotechforb.Repositories.TransactionRepository;
import com.challenge.challengetecnicotechforb.Security.Payload.TransactionResponse;

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;
  @Autowired
  private AccountService accountService;

  public TransactionResponse createTransaction(String token, String destinationAccountId, BigDecimal amount,
      String description) {
    Account origin = accountService.getAccountFromToken(token);

    if (origin.getBalance().compareTo(amount) < 0) {
      throw new IllegalArgumentException("La cuenta de origen no tiene fondos suficientes.");
    }

    Account destinationAccount = accountService.getAccountById(destinationAccountId);

    Transaction transaction = new Transaction();
    transaction.setAccount(origin);
    transaction.setAmount(amount.doubleValue());
    transaction.setDate(LocalDate.now());
    transaction.setDescription(description);

    origin.setBalance(origin.getBalance().subtract(amount));
    destinationAccount.setBalance(destinationAccount.getBalance().add(amount));

    accountService.save(origin);
    accountService.save(destinationAccount);
    transactionRepository.save(transaction);

    return new TransactionResponse(transaction.getAccount().getId(), destinationAccountId, amount, description,
        transaction.getDate().toString());
  }

}
