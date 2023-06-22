package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpenQuestion extends Question {
    public static final int maximumNumberOfCharacters = 250;

    private String answerKey;
}
