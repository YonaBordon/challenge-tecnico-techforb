package com.challenge.challengetecnicotechforb.Mappers;

import com.challenge.challengetecnicotechforb.Entities.Transaction;
import com.challenge.challengetecnicotechforb.Entities.Dto.AccountDTO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

  public static AccountDTO toAccountBalanceDTO(Transaction transaction) {
    AccountDTO dto = new AccountDTO();
    dto.setId(transaction.getAccount().getId());
    dto.setBalance(transaction.getAccount().getBalance());
    dto.setUserId(transaction.getAccount().getUser().getId());
    return dto;

  }

  

}
