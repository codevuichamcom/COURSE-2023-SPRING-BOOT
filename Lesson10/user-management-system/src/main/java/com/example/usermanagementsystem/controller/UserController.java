package com.example.usermanagementsystem.controller;

import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;
import com.example.usermanagementsystem.entity.User;
import com.example.usermanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserDTOResponse createUser(@RequestBody UserDTOCreate userDTOCreate) {
        return userService.createUser(userDTOCreate);
    }
    @GetMapping("/users")
    public List<UserDTOResponse> getAllUser(){
        return userService.getAllUser();
    }
    @GetMapping("/users/{id}")
    public UserDTOResponse getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}")
    public UserDTOResponse updateUser(@RequestBody UserDTOUpdate userDTOUpdate, @PathVariable int id){
        return userService.updateUser(userDTOUpdate,id);
    }

    @DeleteMapping("/users/{id}")
    public UserDTOResponse deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
