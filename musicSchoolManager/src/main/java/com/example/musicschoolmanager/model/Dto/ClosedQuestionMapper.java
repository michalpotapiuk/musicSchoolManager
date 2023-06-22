package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.ClosedQuestion;


public class ClosedQuestionMapper{

    public static ClosedQuestionDto map(ClosedQuestion closedQuestion) {
        ClosedQuestionDto dto = new ClosedQuestionDto(closedQuestion.getText(),closedQuestion.getPoints());
        dto.setPoints(closedQuestion.getPoints());
        dto.setAnswers(closedQuestion.getAnswers());
        dto.setCorrectAnswers(closedQuestion.getCorrectAnswers());
        return dto;
    }

    public static ClosedQuestion map(ClosedQuestionDto closedQuestionDto) {
        ClosedQuestion closedQuestion = new ClosedQuestion();
        closedQuestion.setText(closedQuestionDto.getText());
        closedQuestion.setPoints(closedQuestionDto.getPoints());
        closedQuestion.setAnswers(closedQuestionDto.getAnswers());
        closedQuestion.setCorrectAnswers(closedQuestionDto.getCorrectAnswers());
        return closedQuestion;
    }

}
