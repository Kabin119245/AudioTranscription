package com.security.jwt.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Audio {
    @Id
    private String Id;
    private String textId;
    private String audioFilePath;
    private String user;


}
