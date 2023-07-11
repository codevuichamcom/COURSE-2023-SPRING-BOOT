package com.example.usermanagementsystem.repository;

import com.example.usermanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
