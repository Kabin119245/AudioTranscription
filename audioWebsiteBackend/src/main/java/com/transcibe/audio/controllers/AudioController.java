package com.transcibe.audio.controllers;


import com.transcibe.audio.models.Audio;
import com.transcibe.audio.models.Text;
import com.transcibe.audio.repositories.AudioRepository;
import com.transcibe.audio.repositories.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController


@RequestMapping("/api")
public class AudioController {

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private AudioRepository audioRepository;

    @GetMapping("/texts")

    public List<Text> getTexts() {
        return textRepository.findAll();
    }

    @PostMapping("/audios")
    public Audio uploadAudio(@RequestParam("textId") String textId, @RequestParam("file") MultipartFile file, @RequestParam("user") String user) throws IOException {
        String filePath = saveFile(file);
        Audio audio = new Audio();
        audio.setTextId(textId);
        audio.setAudioFilePath(filePath);
        audio.setUser(user);
        return audioRepository.save(audio);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        String uploadDir = "uploads/";
        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        File uploadFile = new File(uploadDir + fileName);
        file.transferTo(uploadFile);
        return uploadFile.getAbsolutePath();
    }
}


