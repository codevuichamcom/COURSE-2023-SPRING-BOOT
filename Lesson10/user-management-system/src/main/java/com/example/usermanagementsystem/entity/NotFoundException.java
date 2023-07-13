package com.example.usermanagementsystem.entity;

import com.example.usermanagementsystem.model.CustomError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
    CustomError customError;

    public NotFoundException(CustomError customError) {
        this.customError = customError;
    }
}
