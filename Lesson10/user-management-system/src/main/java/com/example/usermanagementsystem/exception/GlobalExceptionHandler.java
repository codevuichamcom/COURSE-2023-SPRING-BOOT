package com.example.usermanagementsystem.exception;

import com.example.usermanagementsystem.entity.NotFoundException;
import com.example.usermanagementsystem.model.CustomError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public CustomError notFoundException(NotFoundException ex){
        return ex.getCustomError();
    }


    @ExceptionHandler(Exception.class)
    public CustomError internalServer(Exception ex){
        return CustomError.builder()
                .code("500")
                .message("Internal server")
                .build();
    }
}
