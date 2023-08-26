package com.example.musicschoolmanager.model.abstracts;

import com.example.musicschoolmanager.model.Realization;
import com.example.musicschoolmanager.model.TeacherClasses;
import jakarta.persistence.*;
import lombok.*;

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
public abstract class AbstractTeacher extends Person {

    private LocalDate employmentDate;
    private BigDecimal salaryPerHour;

    @OneToMany(mappedBy = "abstractTeacher", orphanRemoval = true)
    private Set<Realization> realizations = new HashSet<>();

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    private Set<TeacherClasses> teacherClasses = new HashSet<>();

    public int getSeniority(){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(employmentDate, currentDate);
        return  period.getMonths() + period.getYears() * 12;
    }
}
