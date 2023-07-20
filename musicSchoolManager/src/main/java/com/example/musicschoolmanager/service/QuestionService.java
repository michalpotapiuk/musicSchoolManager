package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.*;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<QuestionDto> findAllQuestions() {
        return questionRepository.findAll().stream()
                .map(QuestionDtoMapper::questionMapToDto)
                .toList();
    }

    public QuestionDto createQuestion(QuestionDto questionDto){
        Question question = QuestionDtoMapper.questionMapToEntity(questionDto);
        Question savedQuestion = questionRepository.save(question);
        return QuestionDtoMapper.questionMapToDto(savedQuestion);
    }


}
