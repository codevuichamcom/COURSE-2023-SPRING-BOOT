package com.example.onlineshop.security;

import com.example.onlineshop.entity.Account;
import com.example.onlineshop.mapper.AccountMapper;
import com.example.onlineshop.model.TokenPayload;
import com.example.onlineshop.repository.AccountRepository;
import com.example.onlineshop.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtRequestFilter extends OncePerRequestFilter {
    JwtTokenUtil jwtTokenUtil;
    AccountRepository accountRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestTokenHeader = request.getHeader("Authorization");

        String token =null;
        TokenPayload tokenPayload = null;
        if(requestTokenHeader!=null&& requestTokenHeader.startsWith("Bearer ")){
            token = requestTokenHeader.split(" ")[1];
            try {
                tokenPayload = jwtTokenUtil.getTokenPayload(token);
            }catch (ExpiredJwtException ex){
                System.out.println("Token is expired");
            }

        }else{
            System.out.println("JWT not start with Bearer");
        }

        if(tokenPayload!=null&& SecurityContextHolder.getContext().getAuthentication() == null){
            Optional<Account> accountOptional = accountRepository.findById(tokenPayload.getAccountId());
            if(accountOptional.isPresent()){
                Account account = accountOptional.get();
                if(jwtTokenUtil.isValid(token, AccountMapper.toTokenPayload(account))){
                    // Tạo user detail -> lưu vào context holder
                }
            }
        }
        filterChain.doFilter(request, response);

    }
}
