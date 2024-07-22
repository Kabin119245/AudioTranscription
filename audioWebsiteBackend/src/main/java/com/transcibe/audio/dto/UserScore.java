package com.transcibe.audio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserScore {
    private String username;
    private int score;

    public UserScore() {
    }

    public UserScore(String username, int score) {
        this.username = username;
        this.score = score;
    }

}

