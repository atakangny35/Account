package com.AccountManagemnt.Account.Dto.Converter;

import com.AccountManagemnt.Account.Dto.AccountDto;
import com.AccountManagemnt.Account.entity.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {
    private  final  CustomerDtoConverter customerDtoConverter;
    private  final  TransactionDtoConverter transactionDtoConverter;
    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convert(Account from){
        return new AccountDto(from.getId(),from.getBalance(),from.getCreatedAt(),
                customerDtoConverter.ConvertToAccountCustomerDto(from.getCustomer()),
                Objects.requireNonNull(from.getTransactions())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet())

        );
    }
}
