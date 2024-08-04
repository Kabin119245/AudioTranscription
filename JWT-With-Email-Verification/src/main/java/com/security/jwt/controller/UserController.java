package com.security.jwt.controller;

import com.security.jwt.model.Audio;
import com.security.jwt.model.Text;
import com.security.jwt.model.User;
import com.security.jwt.repository.AudioRepository;
import com.security.jwt.repository.TextRepository;
import com.security.jwt.service.FileStorage;
import com.security.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    private TextRepository textRepository;


    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    private FileStorage fileStorage;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }


    @PostMapping("/audios")
    public Audio uploadAudio(@RequestParam("file") MultipartFile file) throws IOException {
        String filePath = fileStorage.saveFile(file);
        Audio audio = new Audio();
        System.out.println("Received file with size: " + file.getSize()); // Logging file size
        System.out.println("Received file with type: " + file.getContentType()); // Logging file type
        audio.setAudioFilePath(filePath);
        return audioRepository.save(audio);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from secured";  // Replace with your own logic here.

    }

}
