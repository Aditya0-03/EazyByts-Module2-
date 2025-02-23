package com.example.trading.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Loads register.html from templates/
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "index"; // Loads index.html from templates/
    }
}
