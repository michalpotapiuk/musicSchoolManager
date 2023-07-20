package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.OpenQuestion;

public class OpenQuestionDtoMapper {
    public static OpenQuestionDto map(OpenQuestion openQuestion) {
        OpenQuestionDto openQuestionDto = new OpenQuestionDto();
        openQuestionDto.setId(openQuestion.getId());
        openQuestionDto.setText(openQuestion.getText());
        openQuestionDto.setPoints(openQuestionDto.getPoints());
        openQuestionDto.setAnswerKey(openQuestionDto.getAnswerKey());
        return openQuestionDto;
    }

    public static OpenQuestion map(OpenQuestionDto openQuestionDto) {
        OpenQuestion openQuestion = new OpenQuestion();
        openQuestion.setId(openQuestionDto.getId());
        openQuestion.setText(openQuestionDto.getText());
        openQuestion.setPoints(openQuestionDto.getPoints());
        openQuestion.setAnswerKey(openQuestionDto.getAnswerKey());
        return openQuestion;
    }
}
