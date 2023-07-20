package com.example.musicschoolmanager.model.Dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public abstract class QuestionDto {
    private Long id;
    private String text;
    private Integer points;
}
