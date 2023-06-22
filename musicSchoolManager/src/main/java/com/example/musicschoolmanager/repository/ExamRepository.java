package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long > {
}
