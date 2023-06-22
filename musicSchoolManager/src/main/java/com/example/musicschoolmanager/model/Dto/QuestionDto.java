package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.abstracts.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public abstract class QuestionDto {
    private String text;
    private Integer points;
}
