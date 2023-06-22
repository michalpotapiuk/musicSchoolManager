package com.example.musicschoolmanager.model.abstracts;

import com.example.musicschoolmanager.model.Realization;
import com.example.musicschoolmanager.model.TeacherClasses;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "AbstractTeacher")
public abstract class AbstractTeacher extends Person {

    private LocalDate employmentDate;
    private BigDecimal salaryPerHour;

    @OneToMany(mappedBy = "abstractTeacher", orphanRemoval = true)
    private List<Realization> realizations = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<TeacherClasses> teacherClasses = new ArrayList<>();

    public int getSeniority(){
         return Period.between(employmentDate, LocalDate.now()).getYears();
    }
}
