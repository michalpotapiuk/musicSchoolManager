package com.example.musicschoolmanager.model.Dto;

import com.example.musicschoolmanager.model.Exam;

import java.util.Optional;

public class ExamDtoMapper {

    public static ExamDto map(Exam exam) {
        ExamDto examDTO = new ExamDto();
        examDTO.setId(exam.getId());
        examDTO.setCategory(exam.getCategory());
        examDTO.setInstrumentGroup(exam.getInstrumentGroup());
        examDTO.setExamDate(exam.getExamDate());
        examDTO.setQuestions(QuestionDtoMapper.toDTOList(exam.getQuestions()));
        return examDTO;
    }

    public static Exam map(ExamDto examDto) {
        Exam exam = new Exam();
        exam.setId(examDto.getId());
        exam.setCategory(examDto.getCategory());
        exam.setInstrumentGroup(examDto.getInstrumentGroup());
        exam.setExamDate(examDto.getExamDate());
        exam.setQuestions(QuestionDtoMapper.toEntityList(examDto.getQuestions()));
        return exam;
    }

}
