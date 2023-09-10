package com.AccountManagemnt.Account.repository;

import com.AccountManagemnt.Account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
