package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.AbstractTeacher;
import com.example.musicschoolmanager.model.enums.TeacherType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.EnumSet;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teacher")
@Inheritance(strategy = InheritanceType.JOINED)
public class Teacher extends AbstractTeacher {

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private EnumSet<TeacherType> teacherTypes;


}
