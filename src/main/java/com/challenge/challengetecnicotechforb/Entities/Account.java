package com.challenge.challengetecnicotechforb.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Access level significa que no se puede modificar el balance directamente
    @Column(name = "balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal balance = new BigDecimal("0.00");

    @OneToOne
    @JoinColumn
    private User user;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    public Account(User user) {
        this.user = user;
        this.balance = new BigDecimal("0.00");
    }
}
