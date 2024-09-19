package com.security.jwt.controller;

import com.security.jwt.dto.LoginUserDto;
import com.security.jwt.dto.RegisterUserDto;
import com.security.jwt.dto.VerifyUserDto;
import com.security.jwt.model.Audio;
import com.security.jwt.model.Text;
import com.security.jwt.model.User;
import com.security.jwt.repository.AudioRepository;
import com.security.jwt.repository.TextRepository;
import com.security.jwt.responses.LoginResponse;
import com.security.jwt.service.AuthenticationService;
import com.security.jwt.service.FileStorage;
import com.security.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/auth/")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private FileStorage fileStorage;

    @Autowired
    private AudioRepository audioRepository;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto){
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestBody VerifyUserDto verifyUserDto) {
        try {
            authenticationService.verifyUser(verifyUserDto);
            return ResponseEntity.ok("Account verified successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/resend")
    public ResponseEntity<?> resendVerificationCode(@RequestParam String email) {
        try {
            authenticationService.resendVerificationCode(email);
            return ResponseEntity.ok("Verification code sent");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/greet")
    public String greet(){
        return "Hello World!";
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


    @GetMapping("/texts")
    public List<Text> getTexts() {
        return textRepository.findAll();
    }

    @PostMapping("/texts")
    public Text addText(@RequestBody Text text) {
        return textRepository.save(text);
    }



}
