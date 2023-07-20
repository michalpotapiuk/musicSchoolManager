package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.ExamDto;
import com.example.musicschoolmanager.model.Dto.ExamDtoMapper;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDtoMapper;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.repository.ExamRepository;
import com.example.musicschoolmanager.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Exam> getExamById(Long id) {
        Optional<Exam> examOptional = examRepository.findById(id);
        return examOptional;
    }

    @Transactional
    public void addQuestionToExam(Long examId, QuestionDto questionDto) {

        Optional<Exam> examOptional = examRepository.findById(examId);
        if (examOptional.isEmpty()){
            throw new RuntimeException();
        }

        Exam exam = examOptional.get();

        Question question = QuestionDtoMapper.questionMapToEntity(questionDto);
        question.setText(questionDto.getText());
        question.setPoints(questionDto.getPoints());

        exam.getQuestions().add(question);
        question.getExams().add(exam);

        examRepository.save(exam);
    }


    



}
