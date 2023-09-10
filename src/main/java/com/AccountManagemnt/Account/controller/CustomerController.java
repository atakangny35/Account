package com.AccountManagemnt.Account.controller;

import com.AccountManagemnt.Account.Dto.CustomerDto;
import com.AccountManagemnt.Account.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> GetCustomer(@PathVariable String id){
        return  ResponseEntity.ok(customerService.GetCustomerInfoById(id));
    }
}
