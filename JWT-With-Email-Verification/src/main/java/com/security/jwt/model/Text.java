package com.security.jwt.model;


import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "texts")
@Entity
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String content;
}
