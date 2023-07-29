package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.ClosedQuestion;
import com.example.musicschoolmanager.model.OpenQuestion;
import com.example.musicschoolmanager.model.abstracts.Question;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionDtoMapper {

    public static Set<QuestionDto> toDTOList(Set<Question> questions) {
        Set<QuestionDto> questionDTOs = new HashSet<>();
        for (Question question : questions) {
            questionDTOs.add(map(question));
        }
        return questionDTOs;
    }

    public static Set<Question> toEntityList(Set<QuestionDto> questionDtos) {
        if (questionDtos == null) {
            return Collections.emptySet();
        }
        return questionDtos.stream()
                .map(QuestionDtoMapper::map)
                .collect(Collectors.toSet());
    }


    public static Question map(QuestionDto questionDto) {
        if (questionDto instanceof OpenQuestionDto) {
            return OpenQuestionDtoMapper.map((OpenQuestionDto) questionDto);
        } else if (questionDto instanceof ClosedQuestionDto) {
            return ClosedQuestionMapper.map((ClosedQuestionDto) questionDto);
        } else {
            throw new IllegalArgumentException("Unsupported question DTO type: " + questionDto.getClass().getName());
        }
    }


    public static QuestionDto map(Question question) {
        if (question instanceof OpenQuestion) {
            return OpenQuestionDtoMapper.map((OpenQuestion) question);
        } else if (question instanceof ClosedQuestion) {
            return ClosedQuestionMapper.map((ClosedQuestion) question);
        } else {
            throw new IllegalArgumentException("Unsupported question type: " + question.getClass().getName());
        }
    }
}
