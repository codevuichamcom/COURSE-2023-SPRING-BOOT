package com.funnycode.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam String name) {
        Person p = Person.builder()
                .id(1)
                .name(name)
                .age(25)
                .email("quan@gmail.com")
                .build();
        model.addAttribute("person", p);
        return "hello";
    }
}
