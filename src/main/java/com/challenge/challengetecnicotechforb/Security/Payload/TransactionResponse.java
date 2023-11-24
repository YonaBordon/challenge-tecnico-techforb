package com.challenge.challengetecnicotechforb.Security.Payload;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponse {

  private String origen;
  private String destino;
  private BigDecimal monto;
  private String descripcion;
  private String fecha;

}
