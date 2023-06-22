package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.ClosedQuestion;
import com.example.musicschoolmanager.model.OpenQuestion;
import com.example.musicschoolmanager.model.abstracts.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDtoMapper {

    public static List<QuestionDto> toDTOList(List<Question> questions) {
        List<QuestionDto> questionDTOs = new ArrayList<>();
        for (Question question : questions) {
            questionDTOs.add(questionMapToDto(question));
        }
        return questionDTOs;
    }

    public static List<Question> toEntityList(List<QuestionDto> questionDtos) {
        return questionDtos.stream()
                .map(QuestionDtoMapper::questionMapToEntity)
                .collect(Collectors.toList());
    }


    public static Question questionMapToEntity(QuestionDto questionDto) {
        if (questionDto instanceof OpenQuestionDto) {
            return OpenQuestionDtoMapper.toEntity((OpenQuestionDto) questionDto);
        } else if (questionDto instanceof ClosedQuestionDto) {
            return ClosedQuestionMapper.toEntity((ClosedQuestionDto) questionDto);
        } else {
            throw new IllegalArgumentException("Unsupported question DTO type: " + questionDto.getClass().getName());
        }
    }


    public static QuestionDto questionMapToDto(Question question) {
        if (question instanceof OpenQuestion) {
            return OpenQuestionDtoMapper.toDTO((OpenQuestion) question);
        } else if (question instanceof ClosedQuestion) {
            return ClosedQuestionMapper.toDTO((ClosedQuestion) question);
        } else {
            throw new IllegalArgumentException("Unsupported question type: " + question.getClass().getName());
        }
    }
}
