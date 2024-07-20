package com.transcibe.audio.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "audios")
public class Audio {
    @Id
    private String Id;
    private String textId;
    private String audioFilePath;
    private String user;

}
