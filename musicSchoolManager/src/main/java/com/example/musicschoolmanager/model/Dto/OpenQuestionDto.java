package com.example.musicschoolmanager.model.Dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class OpenQuestionDto extends QuestionDto {
    private String answerKey;

}
