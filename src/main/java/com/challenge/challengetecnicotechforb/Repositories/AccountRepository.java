package com.challenge.challengetecnicotechforb.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.challengetecnicotechforb.Entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
