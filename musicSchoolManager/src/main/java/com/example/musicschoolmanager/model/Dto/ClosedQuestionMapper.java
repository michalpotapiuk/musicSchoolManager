package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.ClosedQuestion;


public class ClosedQuestionMapper{

    public static ClosedQuestionDto map(ClosedQuestion closedQuestion) {
        ClosedQuestionDto closedQuestionDto = new ClosedQuestionDto();
        closedQuestionDto.setId(closedQuestion.getId());
        closedQuestionDto.setText(closedQuestion.getText());
        closedQuestionDto.setPoints(closedQuestion.getPoints());
        closedQuestionDto.setAnswers(closedQuestion.getAnswers());
        closedQuestionDto.setCorrectAnswers(closedQuestion.getCorrectAnswers());
        return closedQuestionDto;
    }

    public static ClosedQuestion map(ClosedQuestionDto closedQuestionDto) {
        ClosedQuestion closedQuestion = new ClosedQuestion();
        closedQuestion.setId(closedQuestionDto.getId());
        closedQuestion.setText(closedQuestionDto.getText());
        closedQuestion.setPoints(closedQuestionDto.getPoints());
        closedQuestion.setAnswers(closedQuestionDto.getAnswers());
        closedQuestion.setCorrectAnswers(closedQuestionDto.getCorrectAnswers());
        return closedQuestion;
    }

}
