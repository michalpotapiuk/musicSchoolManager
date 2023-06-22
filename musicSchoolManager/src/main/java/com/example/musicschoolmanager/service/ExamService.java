package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.ExamDto;
import com.example.musicschoolmanager.model.Dto.ExamDtoMapper;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public ExamDto createExam(ExamDto examDto){
        Exam exam = ExamDtoMapper.map(examDto);
        Exam savedExam = examRepository.save(exam);
        return ExamDtoMapper.map(savedExam);
    }



    public Optional<Exam> getExamById(Long id) {
        Optional<Exam> examOptional = examRepository.findById(id);
        return examOptional;
    }

    public Optional<ExamDto> findExamById(long id) {
        return examRepository.findById(id).map(ExamDtoMapper::map);
    }

    



}
