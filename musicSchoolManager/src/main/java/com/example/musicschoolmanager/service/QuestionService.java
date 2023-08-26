package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDtoMapper;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.repository.ExamRepository;
import com.example.musicschoolmanager.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    public Set<QuestionDto> findAllQuestionsById(Set<Long> id) {
        Set<Question> questions = new HashSet<>(questionRepository.findAllById(id));
        return QuestionDtoMapper.toDTOList(questions);
    }

    @Transactional
    public QuestionDto createQuestion(QuestionDto questionDto){
        Question question = QuestionDtoMapper.map(questionDto);
        Question savedQuestion = questionRepository.save(question);
        return QuestionDtoMapper.map(savedQuestion);
    }

    public List<QuestionDto> findAllQuestions(){
        return questionRepository.findAll().stream()
                .map(QuestionDtoMapper::map)
                .toList();
    }

    public QuestionDto findQuestionById(Long id){
        Question question = questionRepository.findById(id).orElse(null);
        return QuestionDtoMapper.map(question);
    }

    public Set<QuestionDto> findAllExamsQuestions(Long examId){
        Exam exam = examRepository.findById(examId).orElse(null);
        if (exam != null) {
             return QuestionDtoMapper.toDTOList(new HashSet<>(questionRepository.findByExamsId(examId)));
        }
        return null;
    }
    public boolean checkIfQuestionExists(){
        return !questionRepository.findAll().isEmpty();
    }
}
