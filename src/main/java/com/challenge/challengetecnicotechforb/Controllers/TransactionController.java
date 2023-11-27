package com.challenge.challengetecnicotechforb.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.challengetecnicotechforb.Entities.Dto.TransactionRequestDTO;
import com.challenge.challengetecnicotechforb.Entities.Dto.TransactionResponseDTO;
import com.challenge.challengetecnicotechforb.Services.TransactionService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(HttpServletRequest request,
            @RequestBody TransactionRequestDTO transaction) {
        String token = request.getHeader("Authorization");

        return ResponseEntity.ok(transactionService.createTransaction(token, transaction.getIdDestino(),
                transaction.getMonto(), transaction.getDescripcion()));
    }
}
