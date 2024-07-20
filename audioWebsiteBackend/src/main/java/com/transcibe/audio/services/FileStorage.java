package com.transcibe.audio.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class FileStorage {
    private static final String UPLOAD_DIR = "G:\\audioUploads";
    public String saveFile(MultipartFile file) throws IOException {
        // Create the directory if it doesn't exist
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Generate a unique filename
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + fileName);

        // Save the file to the specified path
        Files.write(path, file.getBytes());

        return path.toString();
    }
}
