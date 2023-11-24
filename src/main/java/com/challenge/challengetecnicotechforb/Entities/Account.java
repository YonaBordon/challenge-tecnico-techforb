package com.challenge.challengetecnicotechforb.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "balance", nullable = false, precision = 10, scale = 2)
    private BigDecimal balance = new BigDecimal("0.00");

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    private List<Transaction> transactions;

    public Account(User user) {
        this.user = user;
        this.balance = new BigDecimal("0.00");
    }

}
