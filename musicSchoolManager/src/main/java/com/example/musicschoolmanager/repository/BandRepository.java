package com.example.musicschoolmanager.repository;

import com.example.musicschoolmanager.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
