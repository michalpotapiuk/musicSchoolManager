package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.AbstractTeacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Realization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer hoursSpentPrepering;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private AbstractTeacher abstractTeacher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "band_id")
    private Band band;
}
