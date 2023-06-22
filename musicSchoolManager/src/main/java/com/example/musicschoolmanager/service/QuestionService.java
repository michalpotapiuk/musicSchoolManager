package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDtoMapper;
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
                .map(QuestionDtoMapper::map)
                .toList();
    }

}
