package com.example.musicschoolmanager.model.abstracts;

import com.example.musicschoolmanager.model.Realization;
import com.example.musicschoolmanager.model.TeacherClasses;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "AbstractTeacher")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractTeacher extends Person {

    private LocalDate employmentDate;
    private BigDecimal salaryPerHour;

    @OneToMany(mappedBy = "abstractTeacher", orphanRemoval = true)
    private Set<Realization> realizations = new HashSet<>();

    @OneToMany(mappedBy = "teacher")
    private Set<TeacherClasses> teacherClasses = new HashSet<>();

    public int getSeniority(){
         return Period.between(employmentDate, LocalDate.now()).getYears();
    }
}
