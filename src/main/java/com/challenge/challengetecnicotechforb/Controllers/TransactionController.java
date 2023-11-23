package com.challenge.challengetecnicotechforb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.challengetecnicotechforb.Entities.Account;
import com.challenge.challengetecnicotechforb.Entities.Transaction;
import com.challenge.challengetecnicotechforb.Security.Payload.TransactionRequest;
import com.challenge.challengetecnicotechforb.Security.Payload.TransactionResponse;
import com.challenge.challengetecnicotechforb.Services.TransactionService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(HttpServletRequest request,
            @RequestBody TransactionRequest transaction) {
        String token = request.getHeader("Authorization");

        return ResponseEntity.ok(transactionService.createTransaction(token, transaction.getIdDestino(),
                transaction.getMonto(), transaction.getDescripcion()));

    }
}
