package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.repositories.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UsersController {
    private Users users;
    private PasswordEncoder passwordEncoder;

    public UsersController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/posts/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "posts/register";
    }

    @PostMapping("/posts/register")
    public String saveNewUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/posts/login";
    }
}
