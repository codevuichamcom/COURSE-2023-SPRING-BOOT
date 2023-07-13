package com.example.onlineshop.service;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;

public interface AccountService {
    AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate);
}
