package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.*;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.repository.ExamRepository;
import com.example.musicschoolmanager.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    public ExamDto createExam(ExamDto examDto){
        Exam exam = ExamDtoMapper.map(examDto);
        Exam savedExam = examRepository.save(exam);
        return ExamDtoMapper.map(savedExam);
    }

    public Optional<Exam> findById(Long id) {
        Optional<Exam> examOptional = examRepository.findById(id);
        return examOptional;
    }

    @Transactional
    public void addQuestionToExam(Exam exam, Set<Question> questions) {

        Set<QuestionDto> questionDtos = new HashSet<>();
        for (Question question : questions){
            questionDtos.add(QuestionDtoMapper.map(question));
        }
        for (QuestionDto question : questionDtos){
            exam.getQuestions().add(QuestionDtoMapper.map(question));
        }
        examRepository.save(exam);
    }

    @Transactional
    public void addNewQuestionToExam(ExamDto examDto, QuestionDto questionDto) {
        Question mappedQuestion = QuestionDtoMapper.map(questionDto);
        Exam exam = ExamDtoMapper.map(examDto);
        Set<Question> questions = new HashSet<>();
        questions.add(mappedQuestion);

        for (Question question : questions){
            exam.getQuestions().add(question);
        }
        examRepository.save(exam);
    }
}
