package com.security.jwt.config;



import com.security.jwt.model.UnbiasedText;
import com.security.jwt.repository.UnbiasedTextRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/")
public class UnbiasedTextController {

    @Autowired
    private UnbiasedTextRepository unbiasedTextRepository;


    @GetMapping("/unbiasedText")
    public List<UnbiasedText> getAllTexts() {
        return unbiasedTextRepository.findAll();
    }


    @PostMapping("/addUnbiasedText")
    public List<UnbiasedText> addText(@RequestBody List<UnbiasedText> text) {
        return unbiasedTextRepository.saveAll(text);
    }

}
