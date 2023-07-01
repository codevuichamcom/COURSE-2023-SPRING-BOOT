package com.funnycode.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
//        Person p = Person.builder()
//                .id(1)
//                .age(25)
//                .name("Quan")
//                .build();
//        System.out.println(p);
    }

}
