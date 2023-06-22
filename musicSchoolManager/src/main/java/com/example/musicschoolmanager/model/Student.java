package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.Person;
import com.example.musicschoolmanager.model.enums.DegreeType;
import com.example.musicschoolmanager.model.enums.InstrumentType;
import com.example.musicschoolmanager.model.enums.YearType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;


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
    private List<Participation> participations = new ArrayList<>();

    @ManyToMany
    private List<Band> bands = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<TeacherClasses> teacherClasses = new ArrayList<>();
}
