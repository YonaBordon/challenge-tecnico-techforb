package com.challenge.challengetecnicotechforb.Repositories;

import java.util.List;
import com.challenge.challengetecnicotechforb.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findByAccountId(String accountId);
}
