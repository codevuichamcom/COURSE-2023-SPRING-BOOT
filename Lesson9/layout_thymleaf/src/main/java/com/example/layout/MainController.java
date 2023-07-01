package com.example.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("/products")
    public String products(){
        return "products";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
