package com.example.musicschoolmanager.model.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ClosedQuestionDto extends QuestionDto {
    private List<String> answers;
    private List<String> correctAnswers;
}
