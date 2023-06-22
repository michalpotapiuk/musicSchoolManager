package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
