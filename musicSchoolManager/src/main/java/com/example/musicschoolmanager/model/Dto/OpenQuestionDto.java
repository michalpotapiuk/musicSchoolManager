package com.example.musicschoolmanager.model.Dto;

import lombok.*;

@Getter
@Setter
@ToString
public class OpenQuestionDto extends QuestionDto {
    private String answerKey;


    OpenQuestionDto(String text, Integer points) {
        super(text, points);
    }
}
