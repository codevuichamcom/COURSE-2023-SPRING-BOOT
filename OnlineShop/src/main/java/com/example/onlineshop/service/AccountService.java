package com.example.onlineshop.service;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;
import com.example.onlineshop.dto.LoginDTORequest;
import com.example.onlineshop.dto.LoginDTOResponse;

public interface AccountService {
    AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate);

    LoginDTOResponse login(LoginDTORequest loginDTORequest);
}
