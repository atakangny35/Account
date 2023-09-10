package com.AccountManagemnt.Account.repository;

import com.AccountManagemnt.Account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
