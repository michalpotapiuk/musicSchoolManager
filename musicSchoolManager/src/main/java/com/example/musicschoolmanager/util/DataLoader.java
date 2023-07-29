package com.example.musicschoolmanager.util;

import com.example.musicschoolmanager.model.ClosedQuestion;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.model.OpenQuestion;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.repository.ClosedQuestionRepository;
import com.example.musicschoolmanager.repository.ExamRepository;
import com.example.musicschoolmanager.repository.OpenQuestionRepository;
import com.example.musicschoolmanager.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final QuestionRepository questionRepository;
    private final OpenQuestionRepository openQuestionRepository;
    private final ClosedQuestionRepository clodesQuestionRepository;
    private final ExamRepository examRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

/*        OpenQuestion openQuestion1 = new OpenQuestion();
        openQuestion1.setText("Jak zdac mas?");
        openQuestion1.setPoints(2);
        openQuestion1.setAnswerKey("Trzeba najlepiej stanac na glowie pomachac do Papieza Jana Pawla II i sie usmiechac");

        OpenQuestion openQuestion2 = new OpenQuestion();
        openQuestion2.setText("Co jadles na obiad?");

        ClosedQuestion closedQuestion = new ClosedQuestion();
        closedQuestion.setText("Opisz cos tra");
        closedQuestion.setAnswers(List.of("A", "B", "C", "G"));

        Exam exam = new Exam();
        exam.setCategory("Klasa 1");
        exam.setInstrumentGroup("PErkusja");*/

        // Tworzenie egzaminu
        Exam exam = new Exam();
        exam.setCategory("Muzyka klasyczna");
        exam.setInstrumentGroup("Skrzypce");
        exam.setExamDate(LocalDateTime.now());

// Tworzenie otwartego pytania
        OpenQuestion openQuestion = new OpenQuestion();
        openQuestion.setText("Jak nazywa się twórca symfonii No. 9 'Z nowego świata'?");
        openQuestion.setPoints(10);
        openQuestion.setAnswerKey("Antonín Dvořák");

// Tworzenie zamkniętego pytania
        ClosedQuestion closedQuestion = new ClosedQuestion();
        closedQuestion.setText("Który z tych kompozytorów jest autorem 'Eroiki'?");
        closedQuestion.setPoints(5);

// Ustawianie relacji między pytaniem a egzaminem
//        openQuestion.getExams().add(exam);
//        closedQuestion.getExams().add(exam);
//        exam.getQuestions().add(openQuestion);
//        exam.getQuestions().add(closedQuestion);

        // Zapisywanie danych w bazie danych
        questionRepository.save(openQuestion);
        questionRepository.save(closedQuestion);
        examRepository.save(exam);



/*        questionRepository.save(openQuestion1);
        questionRepository.save(closedQuestion);
        questionRepository.save(openQuestion2);*/
        log.info("Database seed successful");
    }
}
