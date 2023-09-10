package com.AccountManagemnt.Account.repository;

import com.AccountManagemnt.Account.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}
