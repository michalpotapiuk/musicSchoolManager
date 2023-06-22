package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.Exam;

import java.util.Optional;

public class ExamDtoMapper {

    public static ExamDto map(Exam exam) {
        ExamDto dto = new ExamDto();
        dto.setCategory(exam.getCategory());
        dto.setInstrumentGroup(exam.getInstrumentGroup());
        dto.setExamDate(exam.getExamDate());
        //dto.setQuestions(exam.getQuestions());
        return dto;
    }

    public static Exam map(ExamDto examDto) {
        Exam exam = new Exam();
        exam.setCategory(examDto.getCategory());
        exam.setInstrumentGroup(examDto.getInstrumentGroup());
        exam.setExamDate(examDto.getExamDate());
        return exam;
    }

}
