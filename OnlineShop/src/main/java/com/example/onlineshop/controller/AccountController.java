package com.example.onlineshop.controller;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;
import com.example.onlineshop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.onlineshop.util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_VERSION+"/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    public AccountDTOResponse createAccount(@RequestBody AccountDTOCreate accountDTOCreate){
        return accountService.createAccount(accountDTOCreate);
    }
}
