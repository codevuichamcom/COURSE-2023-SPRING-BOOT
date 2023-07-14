package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;
import com.example.onlineshop.entity.Account;
import com.example.onlineshop.model.TokenPayload;

public class AccountMapper {
    public static Account toAccount(AccountDTOCreate accountDTOCreate) {
        return Account.builder()
                .username(accountDTOCreate.getUsername())
                .password(accountDTOCreate.getPassword())
                .email(accountDTOCreate.getEmail())
                .build();
    }

    public static AccountDTOResponse toAccountDTOResponse(Account account) {
        return AccountDTOResponse.builder()
                .id(account.getId())
                .username(account.getUsername())
                .email(account.getEmail())
                .build();
    }

    public static TokenPayload toTokenPayload(Account account) {
        return TokenPayload.builder()
                .accountId(account.getId())
                .username(account.getUsername())
                .build();
    }
}
