package com.challenge.challengetecnicotechforb.Services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.challenge.challengetecnicotechforb.Entities.Account;
import com.challenge.challengetecnicotechforb.Entities.User;
import com.challenge.challengetecnicotechforb.Repositories.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;

  public Account createAccount(User user) {
    Account account = new Account();
    account.setUser(user);
    return accountRepository.save(account);
  }

}
