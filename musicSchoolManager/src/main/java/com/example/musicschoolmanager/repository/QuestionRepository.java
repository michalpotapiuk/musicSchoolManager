package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.abstracts.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long > {
}
