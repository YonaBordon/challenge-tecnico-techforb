package com.challenge.challengetecnicotechforb.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "account_id")
  @JsonBackReference
  private Account account;

  @ManyToOne
  @JoinColumn(name = "destination_account_id")
  private Account destinationAccount;
}