package com.AccountManagemnt.Account.Dto.Converter;

import com.AccountManagemnt.Account.Dto.TransactionDto;
import com.AccountManagemnt.Account.entity.Transaction;
import com.AccountManagemnt.Account.entity.TransactionType;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from){
        return  new TransactionDto(from.getId(), from.getTransactionType(),from.getAmount(),from.getTransactionDate());
    }
}
