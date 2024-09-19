package com.security.jwt.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audios")

public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String textId;
    private String audioFilePath;

}
