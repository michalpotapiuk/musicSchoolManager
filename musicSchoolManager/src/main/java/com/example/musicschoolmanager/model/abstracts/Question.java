package com.example.musicschoolmanager.model.abstracts;

import com.example.musicschoolmanager.model.Exam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Integer points;

    @ManyToMany(mappedBy = "questions", cascade = CascadeType.PERSIST)
    private Set<Exam> exams = new HashSet<>();
}
