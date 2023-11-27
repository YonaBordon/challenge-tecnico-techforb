package com.challenge.challengetecnicotechforb.Entities.Dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class TransactionRequestDTO {
  private String idDestino;
  private BigDecimal monto;
  private String descripcion;

}
