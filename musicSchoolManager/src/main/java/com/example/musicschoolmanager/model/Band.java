package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.enums.LevelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "band")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",unique = true)
    private String name;
    @Column(name = "level")
    private LevelType levelType;

    public static final int maximumNumberOfParticipants = 6;

    @OneToMany(mappedBy = "band", orphanRemoval = true)
    private List<Realization> realizations = new ArrayList<>();

    @ManyToMany
    private List<Track> tracks = new ArrayList<>();

    @ManyToMany(mappedBy = "bands")
    private List<Student> students = new ArrayList<>();
}
