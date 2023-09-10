package com.AccountManagemnt.Account.service;

import com.AccountManagemnt.Account.Dto.Converter.CustomerDtoConverter;
import com.AccountManagemnt.Account.Dto.CustomerDto;
import com.AccountManagemnt.Account.entity.Customer;
import com.AccountManagemnt.Account.exception.CustomerNotFoundException;
import com.AccountManagemnt.Account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private  final CustomerRepository customerRepository;
    private  final CustomerDtoConverter customerDtoConverter;
    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }


    protected Customer GetCustomerById(String id){
        return customerRepository.findById(id)
                .orElseThrow(
                        ()->new CustomerNotFoundException("customer could not found on the system"+id));
    }


    public CustomerDto GetCustomerInfoById(String id){
        Customer customer = this.GetCustomerById(id);
        return  customerDtoConverter.convertToCustomerDto(customer);
    }


}
