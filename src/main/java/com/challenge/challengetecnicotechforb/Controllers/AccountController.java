package com.challenge.challengetecnicotechforb.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.challengetecnicotechforb.Entities.Dto.TransactionResponseDTO;
import com.challenge.challengetecnicotechforb.Services.AccountService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/account")
public class AccountController {

  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/balance")
  public ResponseEntity<String> getBalance(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    return ResponseEntity.ok(accountService.getBalance(token));
  }

  @GetMapping("/transactions")
  public ResponseEntity<List<TransactionResponseDTO>> getTransactions(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    return ResponseEntity.ok(accountService.getTransactions(token));
  }

}
