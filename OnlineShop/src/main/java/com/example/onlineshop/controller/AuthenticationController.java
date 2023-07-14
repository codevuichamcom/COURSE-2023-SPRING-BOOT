package com.example.onlineshop.controller;

import com.example.onlineshop.dto.LoginDTORequest;
import com.example.onlineshop.dto.LoginDTOResponse;
import com.example.onlineshop.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class AuthenticationController {
    AccountService accountService;

    @PostMapping("/login")
    public LoginDTOResponse login(@RequestBody LoginDTORequest loginDTORequest){
        return accountService.login(loginDTORequest);
    }
}
