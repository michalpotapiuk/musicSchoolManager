package com.example.musicschoolmanager.util;

import com.example.musicschoolmanager.model.OpenQuestion;
import com.example.musicschoolmanager.model.Teacher;
import com.example.musicschoolmanager.model.abstracts.Person;
import com.example.musicschoolmanager.model.attribute.ContactData;
import com.example.musicschoolmanager.model.enums.TeacherType;
import com.example.musicschoolmanager.repository.ExamRepository;
import com.example.musicschoolmanager.repository.QuestionRepository;
import com.example.musicschoolmanager.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final ExamRepository examRepository;

    private final QuestionRepository questionRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadData();
    }

    private void loadData() throws Exception {

        ContactData contactRobert = ContactData.builder()
                .email("robercik@gmail.com")
                .phoneNumber("668-882-111")
                .build();


        Teacher robert = new Teacher();
        robert.setTeacherTypes(EnumSet.of(TeacherType.PIANO));
        robert.setFirstName("Robert");
        robert.setLastName("Kubica");
        robert.setPESEL("88080909234");
        robert.setEmploymentDate(LocalDate.of(2023,5,28));
        robert.setSalaryPerHour(BigDecimal.valueOf(36.0));
        System.out.println(robert.getSeniority());
        robert.setContactData(contactRobert);
        robert.setMusicalAchievements(List.of("1 miejsce w ogólno krajowym konkursie pianisty"));
        robert.setKnowledgeOfMusicalStyles(List.of("Klasyczny"));
        teacherRepository.save(robert);


        ContactData contactNatalia = ContactData.builder()
                .email("janoszek@gmail.com")
                .phoneNumber("999-888-932")
                .build();

        Teacher natalia = new Teacher();
        natalia.setTeacherTypes(EnumSet.of(TeacherType.GUITAR, TeacherType.DRUM));
        natalia.setFirstName("Natalia");
        natalia.setLastName("Janoszek");
        natalia.setPESEL("9823434391");
        natalia.setContactData(contactNatalia);
        natalia.setSalaryPerHour(BigDecimal.valueOf(40.0));
        natalia.setKnowledgeOfGuitarTechniques(List.of("Picking", "Tapping"));
        natalia.setDrumInstruments(List.of("Ksylofon", "Kotły", "Wibrafon", "Zestaw perkusyjny"));
        natalia.setEmploymentDate(LocalDate.of(2020, 3, 1));
        System.out.println(natalia.getSeniority());
        teacherRepository.save(natalia);


        ContactData contactRobercik = ContactData.builder()
                .email("lewy@gmail.com")
                .phoneNumber("999-888-333")
                .build();

        Teacher Robercik = new Teacher();
        Robercik.setTeacherTypes(EnumSet.of(TeacherType.PIANO, TeacherType.DRUM, TeacherType.GUITAR));
        Robercik.setFirstName("Robert");
        Robercik.setLastName("Lewandowski");
        Robercik.setPESEL("9343423321");
        Robercik.setContactData(contactRobercik);
        Robercik.setSalaryPerHour(BigDecimal.valueOf(100000.0));
        Robercik.setKnowledgeOfGuitarTechniques(List.of("Picking", "Tapping", "Sweep picking", "BassSlap", "Vibrato"));
        Robercik.setKnowledgeOfMusicalStyles(List.of("Jazz", "Klasyczny"));
        Robercik.setMusicalAchievements(List.of("Człowiek orkiestra roku"));
        Robercik.setKnowledgeOfDrumTechniques(List.of("Paradidle", "Flam", "Rimshot"));
        Robercik.setDrumInstruments(List.of("Ksylofon", "Kotły", "Wibrafon", "Zestaw perkusyjny"));
        Robercik.setEmploymentDate(LocalDate.of(2020, 3, 1));
        System.out.println(Robercik.getSeniority());
        teacherRepository.save(Robercik);


        log.info("Database seed successful");
    }
}
