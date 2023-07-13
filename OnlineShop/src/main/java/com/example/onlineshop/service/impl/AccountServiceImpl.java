package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;
import com.example.onlineshop.entity.Account;
import com.example.onlineshop.mapper.AccountMapper;
import com.example.onlineshop.repository.AccountRepository;
import com.example.onlineshop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Override
    public AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate) {
        Account account = AccountMapper.toAccount(accountDTOCreate);
        account = accountRepository.save(account);
        return AccountMapper.toAccountDTOResponse(account);
    }
}
