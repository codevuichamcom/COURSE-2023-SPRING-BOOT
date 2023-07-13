package com.example.usermanagementsystem.service.impl;

import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;
import com.example.usermanagementsystem.entity.NotFoundException;
import com.example.usermanagementsystem.entity.User;
import com.example.usermanagementsystem.model.CustomError;
import com.example.usermanagementsystem.repository.UserRepository;
import com.example.usermanagementsystem.service.UserService;
import com.example.usermanagementsystem.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTOResponse createUser(UserDTOCreate userDTOCreate) {
        //Chuyen dto sang entity
        User user = UserMapper.toUser(userDTOCreate);
        user = userRepository.save(user);
        //Map tu entity -> DTO de gui cho controller
        return UserMapper.toUserDTOResponse(user);
    }

    @Override
    public List<UserDTOResponse> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDTOResponse> userDTOResponseList = new ArrayList<>();
        for (User user : userList) {
            userDTOResponseList.add(UserMapper.toUserDTOResponse(user));
        }
        return userDTOResponseList;
    }

    @Override
    public UserDTOResponse getUserById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new NotFoundException(CustomError.builder().code("404").message("User does not exist").build());
        } else {
            return UserMapper.toUserDTOResponse(userOptional.get());
        }

    }

    @Override
    public UserDTOResponse updateUser(UserDTOUpdate userDTOUpdate, int id) {
        User user = UserMapper.toUser(userDTOUpdate);
        user.setId(id);
        user = userRepository.save(user);
        return UserMapper.toUserDTOResponse(user);
    }

    @Override
    public UserDTOResponse deleteUser(int id) {
        User user  = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(CustomError
                        .builder()
                        .code("404")
                        .message("User does not exist")
                        .build()));
        userRepository.delete(user);
        return UserMapper.toUserDTOResponse(user);
    }
}
