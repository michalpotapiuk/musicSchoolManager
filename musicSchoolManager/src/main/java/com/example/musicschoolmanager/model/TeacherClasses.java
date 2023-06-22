package com.example.musicschoolmanager.model;

import com.example.musicschoolmanager.model.abstracts.AbstractTeacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private LocalDateTime startDate;
    private Duration duration;

    public static final Duration maximumDuration = Duration.ofMinutes(45);

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private AbstractTeacher teacher;
}
