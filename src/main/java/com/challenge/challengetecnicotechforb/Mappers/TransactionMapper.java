package com.challenge.challengetecnicotechforb.Mappers;

import java.util.List;

import com.challenge.challengetecnicotechforb.Entities.Account;
import com.challenge.challengetecnicotechforb.Entities.Transaction;
import com.challenge.challengetecnicotechforb.Entities.Dto.TransactionRequestDTO;
import com.challenge.challengetecnicotechforb.Entities.Dto.TransactionResponseDTO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TransactionMapper {
  public static Transaction toTransaction(TransactionRequestDTO dto, Account sourceAccount,
      Account destinationAccount) {
    Transaction transaction = new Transaction();
    transaction.setAccount(sourceAccount);
    transaction.setDestinationAccount(destinationAccount);
    transaction.setAmount(dto.getMonto());
    transaction.setDescription(dto.getDescripcion());
    return transaction;
  }

  public static TransactionResponseDTO toTransactionResponseDTO(Transaction transaction) {
    TransactionResponseDTO dto = new TransactionResponseDTO();
    dto.setId(transaction.getId());
    dto.setSourceAccountId(transaction.getAccount().getId());
    dto.setDestinationAccountId(transaction.getDestinationAccount().getId());
    dto.setMonto(transaction.getAmount());
    dto.setDescripcion(transaction.getDescription());
    return dto;
  }

  public static List<TransactionResponseDTO> toTransactionDTO(List<Transaction> transactions) {
    return transactions.stream().map(TransactionMapper::toTransactionResponseDTO).toList();
  }
}
