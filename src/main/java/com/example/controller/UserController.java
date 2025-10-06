package com.example.controller;

import com.example.dto.LogInRequest;
import com.example.dto.RegisterRequest;
import com.example.dto.UserResponse;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request.getUsername(), request.getEmail(), request.getPassword());
    }


    @PostMapping("/login")
    public UserResponse login(@RequestBody LogInRequest request) {
        return userService.login(request.getUsername(), request.getPassword());
    }
}
