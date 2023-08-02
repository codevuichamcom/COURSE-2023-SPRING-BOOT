package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.AccountDTOCreate;
import com.example.onlineshop.dto.AccountDTOResponse;
import com.example.onlineshop.dto.LoginDTORequest;
import com.example.onlineshop.dto.LoginDTOResponse;
import com.example.onlineshop.entity.Account;
import com.example.onlineshop.exception.OnlineShopException;
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

    // TH1: Username is null => ko cho tao
    // TH2: Email is null => Ko cho tao
    // TH3: Username is existed => ko cho tao
    // TH4: Email is existed => Ko cho tao
    // TH5: Tao account thanh cong
    @Override
    public AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate) {
        validateAccountDTOCreate(accountDTOCreate);
        Account account = AccountMapper.toAccount(accountDTOCreate);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account = accountRepository.save(account);
        return AccountMapper.toAccountDTOResponse(account);
    }

    private void validateAccountDTOCreate(AccountDTOCreate accountDTOCreate) {
        if(accountDTOCreate.getUsername() == null){
            throw OnlineShopException.badRequest("Username must be not null");
        }
        if(accountDTOCreate.getEmail() == null){
            throw OnlineShopException.badRequest("Email must be not null");
        }
        if(accountRepository.existsByUsername(accountDTOCreate.getUsername())){
            throw OnlineShopException.badRequest("Username is existed");
        }
        if(accountRepository.existsByEmail(accountDTOCreate.getEmail())){
            throw OnlineShopException.badRequest("Email is existed");
        }
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
            throw OnlineShopException.badRequest("Username or password is incorrect");
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
