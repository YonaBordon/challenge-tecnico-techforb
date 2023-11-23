package com.challenge.challengetecnicotechforb.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.challengetecnicotechforb.Entities.Account;
import com.challenge.challengetecnicotechforb.Entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findById(String accountId);

    Account findByUser(User user);
}

