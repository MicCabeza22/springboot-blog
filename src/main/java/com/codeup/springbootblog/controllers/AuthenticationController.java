package com.codeup.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/posts/login")
    public String showLoginForm() {
        return "posts/login";
    }
}
