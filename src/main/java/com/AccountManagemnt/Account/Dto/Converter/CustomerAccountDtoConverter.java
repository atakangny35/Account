package com.AccountManagemnt.Account.Dto.Converter;

import com.AccountManagemnt.Account.Dto.CustomerAccountDto;
import com.AccountManagemnt.Account.Dto.TransactionDto;
import com.AccountManagemnt.Account.entity.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
private  final  TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert (Account from){

        return new CustomerAccountDto(
                from.getId(),
                from.getBalance(),
                from.getCreatedAt(),
                from.getTransactions().stream().map(transactionDtoConverter::convert).collect(Collectors.toSet())
                );
    }
}
