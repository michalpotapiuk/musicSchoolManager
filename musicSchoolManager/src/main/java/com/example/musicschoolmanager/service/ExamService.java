package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.ExamDto;
import com.example.musicschoolmanager.model.Dto.ExamDtoMapper;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDtoMapper;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.repository.ExamRepository;
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

    public ExamDto createExam(ExamDto examDto){
        Exam exam = ExamDtoMapper.map(examDto);
        Exam savedExam = examRepository.save(exam);
        return ExamDtoMapper.map(savedExam);
    }

    public ExamDto findById(Long id) {
        Optional<Exam> examOptional = examRepository.findById(id);
        return examOptional.map(ExamDtoMapper::map).orElse(null);
    }

    @Transactional
    public void addQuestionToExam(ExamDto examDto, Set<QuestionDto> questionDtos) {

        Set<Question> questionSet = new HashSet<>();
        Exam exam = ExamDtoMapper.map(examDto);
        for (QuestionDto questionDto : questionDtos){
            Question mappedQuestion = QuestionDtoMapper.map(questionDto);
            questionSet.add(mappedQuestion);
        }
        for (Question question : questionSet){
            exam.getQuestions().add(question);
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
