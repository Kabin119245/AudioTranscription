package com.transcibe.audio.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String id;
    private String username;
    private List<String> transcriptionIds;

    // Get score based on the number of transcriptions
    public int getScore() {
        return (this.transcriptionIds != null ? this.transcriptionIds.size() : 0) * 10;
    }




}
