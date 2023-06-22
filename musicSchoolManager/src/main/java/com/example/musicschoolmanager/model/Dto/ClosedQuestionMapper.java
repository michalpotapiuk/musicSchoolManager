package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.ClosedQuestion;


public class ClosedQuestionMapper{

    public static ClosedQuestionDto toDTO(ClosedQuestion closedQuestion) {
        ClosedQuestionDto closedQuestionDto = new ClosedQuestionDto();
        closedQuestionDto.setId(closedQuestion.getId());
        closedQuestionDto.setText(closedQuestion.getText());
        closedQuestionDto.setAnswers(closedQuestion.getAnswers());
        closedQuestionDto.setCorrectAnswers(closedQuestion.getCorrectAnswers());
        return closedQuestionDto;
    }

    public static ClosedQuestion toEntity(ClosedQuestionDto closedQuestionDto) {
        ClosedQuestion closedQuestion = new ClosedQuestion();
        closedQuestion.setId(closedQuestionDto.getId());
        closedQuestion.setText(closedQuestionDto.getText());
        closedQuestion.setAnswers(closedQuestionDto.getAnswers());
        closedQuestion.setCorrectAnswers(closedQuestionDto.getCorrectAnswers());
        return closedQuestion;
    }

}
