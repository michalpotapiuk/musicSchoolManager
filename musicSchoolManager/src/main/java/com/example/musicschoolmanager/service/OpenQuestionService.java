package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.OpenQuestionDto;
import com.example.musicschoolmanager.model.Dto.OpenQuestionDtoMapper;
import com.example.musicschoolmanager.model.OpenQuestion;
import com.example.musicschoolmanager.repository.OpenQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenQuestionService {

    private final OpenQuestionRepository openQuestionRepository;

    public OpenQuestionDto saveOpenQuestion(OpenQuestionDto openQuestionDto){
        OpenQuestion openQuestion = OpenQuestionDtoMapper.map(openQuestionDto);
        OpenQuestion savedOpenQuestion = openQuestionRepository.save(openQuestion);
        return OpenQuestionDtoMapper.map(savedOpenQuestion);
    }

}
