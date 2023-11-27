package com.challenge.challengetecnicotechforb.Entities.Dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountDTO {
  private String id;
  private Long userId;
  private BigDecimal balance;

}
