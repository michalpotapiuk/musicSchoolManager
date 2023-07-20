package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.enums.DifficultyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    @JoinColumn(name = "track_authorities")
    private List<String> authorities = new ArrayList<>();
    @Column(name = "length")
    private Duration trackLength;
    @Column(name = "difficultyType")
    private DifficultyType difficultyType;

    @ManyToMany(mappedBy = "tracks")
    private Set<Band> bands = new HashSet<>();

}
