package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.abstracts.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
