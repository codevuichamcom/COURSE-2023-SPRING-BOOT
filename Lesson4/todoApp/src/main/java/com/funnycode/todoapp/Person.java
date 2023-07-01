package com.funnycode.todoapp;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Person {
    private int id;
    private String name;
    private int age;
    @ToString.Exclude
    private String email;

}
