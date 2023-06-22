package com.example.musicschoolmanager.model.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ExamDto {
    private String category;
    private String instrumentGroup ;
    private LocalDateTime examDate;
    private List<QuestionDto> questions;

}
