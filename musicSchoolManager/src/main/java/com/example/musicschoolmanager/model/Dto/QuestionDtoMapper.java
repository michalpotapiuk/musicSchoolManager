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
            return toEntity((OpenQuestionDto) questionDto);
        } else if (questionDto instanceof ClosedQuestionDto) {
            return toEntity((ClosedQuestionDto) questionDto);
        } else {
            throw new IllegalArgumentException("Unsupported question DTO type: " + questionDto.getClass().getName());
        }
    }


    public static QuestionDto questionMapToDto(Question question) {
        if (question instanceof OpenQuestion) {
            return toDTO((OpenQuestion) question);
        } else if (question instanceof ClosedQuestion) {
            return toDTO((ClosedQuestion) question);
        } else {
            throw new IllegalArgumentException("Unsupported question type: " + question.getClass().getName());
        }
    }


    public static OpenQuestionDto toDTO(OpenQuestion openQuestion) {
        OpenQuestionDto openQuestionDto = new OpenQuestionDto();
        openQuestionDto.setId(openQuestion.getId());
        openQuestionDto.setText(openQuestion.getText());
        openQuestionDto.setAnswerKey(openQuestionDto.getAnswerKey());
        return openQuestionDto;
    }

    public static OpenQuestion toEntity(OpenQuestionDto openQuestionDto) {
        OpenQuestion openQuestion = new OpenQuestion();
        openQuestion.setId(openQuestionDto.getId());
        openQuestion.setText(openQuestionDto.getText());
        openQuestion.setAnswerKey(openQuestionDto.getAnswerKey());
        return openQuestion;
    }


    public static ClosedQuestionDto toDTO(ClosedQuestion closedQuestion) {
        ClosedQuestionDto closedQuestionDto = new ClosedQuestionDto();
        closedQuestionDto.setId(closedQuestion.getId());
        closedQuestionDto.setText(closedQuestion.getText());
        closedQuestionDto.setAnswers(closedQuestion.getAnswers());
        closedQuestionDto.setCorrectAnswers(closedQuestion.getCorrectAnswers());
        return closedQuestionDto;
    }

    public static ClosedQuestion toEntity(ClosedQuestionDto closedQuestionDto) {
        ClosedQuestion closedQuestion = new ClosedQuestion();
        closedQuestion.setId(closedQuestionDto.getId());
        closedQuestion.setText(closedQuestionDto.getText());
        closedQuestion.setAnswers(closedQuestionDto.getAnswers());
        closedQuestion.setCorrectAnswers(closedQuestionDto.getCorrectAnswers());
        return closedQuestion;
    }
}
