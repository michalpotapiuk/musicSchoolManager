package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.Question;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClosedQuestion extends Question {
    public static final int maximumNumberOfAnswers = 4;


    @ElementCollection
    @JoinTable(name = "ClosedQuestion_all_answers")
    private List<String> answers;

    @ElementCollection
    @JoinTable(name = "ClosedQuestion_all_correct_answers")
    private List<String> correctAnswers;
}
