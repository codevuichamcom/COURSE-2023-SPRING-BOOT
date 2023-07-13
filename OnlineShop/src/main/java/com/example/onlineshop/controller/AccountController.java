package com.example.onlineshop.controller;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;
import com.example.onlineshop.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private AccountService accountService;

    @PostMapping("/accounts")
    public AccountDTOResponse createAccount(@RequestBody AccountDTOCreate accountDTOCreate){
        return accountService.createAccount(accountDTOCreate);
    }
}
