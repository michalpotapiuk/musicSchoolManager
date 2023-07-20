package com.example.musicschoolmanager.model.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class ExamDto {

    public Long id;
    private String category;
    private String instrumentGroup ;
    private LocalDateTime examDate;
    private Set<QuestionDto> questions;

}
