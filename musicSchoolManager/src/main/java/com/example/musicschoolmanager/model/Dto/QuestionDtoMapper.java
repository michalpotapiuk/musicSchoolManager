package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.ClosedQuestion;
import com.example.musicschoolmanager.model.OpenQuestion;
import com.example.musicschoolmanager.model.abstracts.Question;

public class QuestionDtoMapper {
    public static QuestionDto map(Question question) {
        return new OpenQuestionDto(
                question.getText(),
                question.getPoints()
        );
    }


}
