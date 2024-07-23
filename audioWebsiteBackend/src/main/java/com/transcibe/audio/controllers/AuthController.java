package com.transcibe.audio.controllers;


import com.transcibe.audio.models.User;

import com.transcibe.audio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user) {
//        System.out.println("Received registration request for user: " + user.getName());
//        userService.registerUser(user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
//
//        return "User registered successfully";
//    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        System.out.println("Received registration request for user: " + user.getName());
        userService.registerUser(user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
        System.out.println("User registered successfully with email: " + user.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");

        return ResponseEntity.ok(response);
    }
}
