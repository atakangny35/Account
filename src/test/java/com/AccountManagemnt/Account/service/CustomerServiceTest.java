package com.AccountManagemnt.Account.service;

import com.AccountManagemnt.Account.Dto.Converter.CustomerDtoConverter;
import com.AccountManagemnt.Account.entity.Customer;
import com.AccountManagemnt.Account.exception.CustomerNotFoundException;
import com.AccountManagemnt.Account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {


    private CustomerService service;

    private CustomerRepository customerRepository;

    private CustomerDtoConverter customerDtoConverter;

    @BeforeEach
    public void setUp(){
        customerRepository = mock(CustomerRepository.class);
        customerDtoConverter = mock(CustomerDtoConverter.class);
        service = new CustomerService(customerRepository,customerDtoConverter);
    }

    @Test
    public  void TestGetCustomerById_WhencustemerIdExists_ShouldReturnCustomer(){
        Customer customer = new Customer("id","hasan","gunay", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.of(customer));

        Customer result =service.GetCustomerById("id");

        assertEquals(result,customer);

    }


    @Test
    public  void TestGetCustomerById_WhencustemerIdNotExists_ShouldThrowNotFOundException(){
       /// Customer customer = new Customer("id","hasan","gunay", Set.of());
        Mockito.when(customerRepository.findById("id")).thenReturn(Optional.empty());



        assertThrows(CustomerNotFoundException.class,()->service.GetCustomerById("id"));

    }
}