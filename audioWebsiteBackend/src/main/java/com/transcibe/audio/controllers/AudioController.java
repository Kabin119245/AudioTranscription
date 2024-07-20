package com.transcibe.audio.controllers;


import com.transcibe.audio.models.Audio;
import com.transcibe.audio.models.Text;
import com.transcibe.audio.repositories.AudioRepository;
import com.transcibe.audio.repositories.TextRepository;
import com.transcibe.audio.services.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController

@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AudioController {

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private AudioRepository audioRepository;

    @Autowired
    private FileStorage fileStorage;

    @GetMapping("/texts")

    public List<Text> getTexts() {
        return textRepository.findAll();
    }

    @PostMapping("/texts")
    public Text addText(@RequestBody Text text) {
        return textRepository.save(text);
    }



    @PostMapping("/audios")
    public Audio uploadAudio(@RequestParam("textId") String textId, @RequestParam("file") MultipartFile file, @RequestParam("user") String user) throws IOException {
        String filePath = fileStorage.saveFile(file);
        Audio audio = new Audio();
        audio.setTextId(textId);
        audio.setAudioFilePath(filePath);
        audio.setUser(user);
        return audioRepository.save(audio);
    }
}


