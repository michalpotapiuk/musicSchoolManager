package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
