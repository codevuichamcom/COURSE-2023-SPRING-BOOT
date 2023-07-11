package com.example.usermanagementsystem.service;

import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;
import com.example.usermanagementsystem.entity.User;

import java.util.List;

public interface UserService {
    UserDTOResponse createUser(UserDTOCreate userDTOCreate);

    List<UserDTOResponse> getAllUser();

    UserDTOResponse getUserById(int id);

    UserDTOResponse updateUser(UserDTOUpdate userDTOUpdate, int id);

    UserDTOResponse deleteUser(int id);
}
