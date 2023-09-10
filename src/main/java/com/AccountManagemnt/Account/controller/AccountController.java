package com.AccountManagemnt.Account.controller;

import com.AccountManagemnt.Account.Dto.AccountDto;
import com.AccountManagemnt.Account.Dto.CreateAccountRequest;
import com.AccountManagemnt.Account.entity.Account;
import com.AccountManagemnt.Account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private  final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> AddAccount(@Valid @RequestBody CreateAccountRequest request){

        return ResponseEntity.ok(accountService.createNewAccount(request));
    }
}
