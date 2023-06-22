package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.abstracts.AbstractTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractTeacherRepository extends JpaRepository<AbstractTeacher, Long > {
}
