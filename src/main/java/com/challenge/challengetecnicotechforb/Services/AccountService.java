package com.challenge.challengetecnicotechforb.Services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.challenge.challengetecnicotechforb.Entities.Account;
import com.challenge.challengetecnicotechforb.Entities.User;
import com.challenge.challengetecnicotechforb.Repositories.AccountRepository;
import com.challenge.challengetecnicotechforb.Repositories.UserRepository;
import com.challenge.challengetecnicotechforb.Security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final UserRepository userRepository;
  private final AccountRepository accountRepository;
  private final JwtService jwtService;
  private final Random random = new Random();

  public Account createAccount(User user) {

    if (user == null || user.getId() == null) {
      throw new IllegalArgumentException("User must not be null and must be saved in the database");
    }

    Account account = new Account();
    String currentDate = new Date(System.currentTimeMillis()).toString().replace("-", "");
    int randomFourthDigits = random.nextInt(9000) + 1000;
    account.setId(user.getId() + "/" + randomFourthDigits + currentDate);
    account.setBalance(new BigDecimal("0.00"));
    account.setUser(user);
    return accountRepository.save(account);
  }

  public Account save(Account account) {
    return accountRepository.save(account);
  }

  public Account findByUserName(String username) {
    User user = userRepository.findByUsername(username).orElseThrow();
    return accountRepository.findByUser(user);
  }

  public Account getAccountFromToken(String token) {
    String accountUser = jwtService.getUsernameFromToken(token);
    return findByUserName(accountUser);
  }

  public Account getAccountById(String accountId) {
    return accountRepository.findById(accountId);
  }

  public String getBalance(String token) {
    Account account = getAccountFromToken(token);
    return account.getBalance().toString();
  }

}
