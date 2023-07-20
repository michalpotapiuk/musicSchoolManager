package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.Person;
import com.example.musicschoolmanager.model.enums.DegreeType;
import com.example.musicschoolmanager.model.enums.InstrumentType;
import com.example.musicschoolmanager.model.enums.YearType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends Person {

    private InstrumentType instrumentType;
    private YearType yearType;
    private DegreeType degreeType;

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private Set<Participation> participations = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "student_band",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "band_id"))
    private Set<Band> bands = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<TeacherClasses> teacherClasses = new HashSet<>();
}
