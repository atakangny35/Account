package com.AccountManagemnt.Account.service;

import com.AccountManagemnt.Account.Dto.AccountDto;
import com.AccountManagemnt.Account.Dto.Converter.AccountDtoConverter;
import com.AccountManagemnt.Account.Dto.CreateAccountRequest;
import com.AccountManagemnt.Account.entity.Account;
import com.AccountManagemnt.Account.entity.Customer;
import com.AccountManagemnt.Account.entity.Transaction;
import com.AccountManagemnt.Account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private  final CustomerService customerService;

    private  final AccountDtoConverter converter;
    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createNewAccount(CreateAccountRequest accountRequest){
    Customer customer= customerService.GetCustomerById(accountRequest.getCustomerId());
        Account account=
                new Account(
                        accountRequest.getInitialCredit(),
                        LocalDateTime.now(),
                        customer);

        if(accountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0)
        {
            //Transaction transaction =  transactionService.initiateMoney(account,accountRequest.getInitialCredit());
            Transaction transaction= new Transaction(accountRequest.getInitialCredit(),account);
            account.getTransactions().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }
}
