package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.enums.LevelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Realization> realizations = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "band_track",
            joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name = "track_id"))
    private Set<Track> tracks = new HashSet<>();

    @ManyToMany(mappedBy = "bands")
    private Set<Student> students = new HashSet<>();
}
