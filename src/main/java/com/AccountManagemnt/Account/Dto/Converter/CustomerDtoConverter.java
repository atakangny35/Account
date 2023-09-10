package com.AccountManagemnt.Account.Dto.Converter;

import com.AccountManagemnt.Account.Dto.AccountCustomerDto;
import com.AccountManagemnt.Account.Dto.CustomerDto;
import com.AccountManagemnt.Account.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private  final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }

    public AccountCustomerDto ConvertToAccountCustomerDto(Customer from){
    if(from==null){
        return  new AccountCustomerDto("","","");
    }
    return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
}

public CustomerDto convertToCustomerDto(Customer from){

    return  new CustomerDto(from.getId(),
            from.getName(),
            from.getSurname(),
            from.getAccounts().stream().map(customerAccountDtoConverter::convert).collect(Collectors.toSet())
            );
}


}
