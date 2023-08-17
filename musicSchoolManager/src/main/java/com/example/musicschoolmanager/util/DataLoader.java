package com.example.musicschoolmanager.util;

import com.example.musicschoolmanager.model.OpenQuestion;
import com.example.musicschoolmanager.model.Teacher;
import com.example.musicschoolmanager.model.enums.TeacherType;
import com.example.musicschoolmanager.repository.ExamRepository;
import com.example.musicschoolmanager.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.EnumSet;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final ExamRepository examRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Adam");
        teacher1.setTeacherTypes(EnumSet.of(TeacherType.GUITAR, TeacherType.DRUM));
        teacher1.setKnowledgeOfGuitarTechniques(List.of("AAAA"));

        teacherRepository.save(teacher1);

        log.info("Database seed successful");
    }
}
