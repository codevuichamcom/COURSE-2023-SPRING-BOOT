package com.example.usermanagementsystem.service.impl;

import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;
import com.example.usermanagementsystem.entity.User;
import com.example.usermanagementsystem.repository.UserRepository;
import com.example.usermanagementsystem.service.UserService;
import com.example.usermanagementsystem.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        User user = userRepository.findById(id).get();
        return UserMapper.toUserDTOResponse(user);
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
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return UserMapper.toUserDTOResponse(user);
    }
}
