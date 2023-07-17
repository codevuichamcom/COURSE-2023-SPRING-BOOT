package com.example.onlineshop.controller;

import com.example.onlineshop.dto.LoginDTORequest;
import com.example.onlineshop.dto.LoginDTOResponse;
import com.example.onlineshop.service.AccountService;
import com.example.onlineshop.util.Constant;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.onlineshop.util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping(API_VERSION)
public class AuthenticationController {
    AccountService accountService;

    @PostMapping("/login")
    public LoginDTOResponse login(@RequestBody LoginDTORequest loginDTORequest){
        return accountService.login(loginDTORequest);
    }
}
