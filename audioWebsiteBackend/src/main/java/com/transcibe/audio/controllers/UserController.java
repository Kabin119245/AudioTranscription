package com.transcibe.audio.controllers;


import com.transcibe.audio.dto.UserScore;
import com.transcibe.audio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/scores")
    public List<UserScore> getUserScores() {
        return userRepository.findAll().stream()
                .map(user -> new UserScore(user.getUsername(), user.getScore()))
                .collect(Collectors.toList());
    }

}
