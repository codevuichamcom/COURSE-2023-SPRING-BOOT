package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;
import com.example.onlineshop.dto.LoginDTORequest;
import com.example.onlineshop.dto.LoginDTOResponse;
import com.example.onlineshop.entity.Account;
import com.example.onlineshop.mapper.AccountMapper;
import com.example.onlineshop.repository.AccountRepository;
import com.example.onlineshop.service.AccountService;
import com.example.onlineshop.util.JwtTokenUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    PasswordEncoder passwordEncoder;
    JwtTokenUtil jwtTokenUtil;

    @Override
    public AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate) {
        Account account = AccountMapper.toAccount(accountDTOCreate);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account = accountRepository.save(account);
        return AccountMapper.toAccountDTOResponse(account);
    }

    @Override
    public LoginDTOResponse login(LoginDTORequest loginDTORequest) {
        //Lay account theo username;
        Account account = accountRepository.findByUsername(loginDTORequest.getUsername())
                .orElseThrow(()->new RuntimeException("Account not found"));
        //kiem tra password
        boolean isAuthentication = passwordEncoder
                .matches(loginDTORequest.getPassword(), account.getPassword());
        if(!isAuthentication){
            throw new RuntimeException("Username or password is incorrect");
        }
        //ok->gen token
        final int ONE_DAY = 24 * 60 *60;
        String accessToken = jwtTokenUtil.generateToken(AccountMapper.toTokenPayload(account),ONE_DAY);
        //tra ve cho nguoi dung
        return LoginDTOResponse.builder()
                .account(AccountMapper.toAccountDTOResponse(account))
                .accessToken(accessToken)
                .build();
    }
}
