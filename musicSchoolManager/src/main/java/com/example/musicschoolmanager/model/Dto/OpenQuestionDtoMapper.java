package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.OpenQuestion;

public class OpenQuestionDtoMapper {
    public static OpenQuestionDto map(OpenQuestion openQuestion) {
        OpenQuestionDto dto = new OpenQuestionDto(openQuestion.getText(), openQuestion.getPoints());
        dto.setAnswerKey(openQuestion.getAnswerKey());
        return dto;
    }

    public static OpenQuestion map(OpenQuestionDto openQuestionDto) {
        OpenQuestion openQuestion = new OpenQuestion();
        openQuestion.setText(openQuestionDto.getText());
        openQuestion.setPoints(openQuestionDto.getPoints());
        openQuestion.setAnswerKey(openQuestionDto.getAnswerKey());
        return openQuestion;
    }
}
