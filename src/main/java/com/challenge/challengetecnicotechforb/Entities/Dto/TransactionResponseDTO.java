package com.challenge.challengetecnicotechforb.Entities.Dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransactionResponseDTO {
  private Long id;
  private String sourceAccountId;
  private String destinationAccountId;
  private BigDecimal monto;
  private String descripcion;

}
