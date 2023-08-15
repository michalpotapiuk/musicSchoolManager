package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.abstracts.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long > {

    Set<Question> findByExamsId(Long examId);
}
