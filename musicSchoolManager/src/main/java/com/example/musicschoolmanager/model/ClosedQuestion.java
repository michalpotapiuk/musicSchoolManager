package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.Question;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClosedQuestion extends Question {
    public static final int maximumNumberOfAnswers = 4;


    @ElementCollection
    @JoinTable(name = "ClosedQuestion_all_answers")
    private List<String> answers = new ArrayList<>();

    @ElementCollection
    @JoinTable(name = "ClosedQuestion_all_correct_answers")
    private List<String> correctAnswers = new ArrayList<>();
}
