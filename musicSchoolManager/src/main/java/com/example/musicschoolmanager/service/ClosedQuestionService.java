package com.example.musicschoolmanager.service;


import com.example.musicschoolmanager.model.ClosedQuestion;
import com.example.musicschoolmanager.model.Dto.ClosedQuestionDto;
import com.example.musicschoolmanager.model.Dto.ClosedQuestionMapper;
import com.example.musicschoolmanager.repository.ClosedQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClosedQuestionService {
    private final ClosedQuestionRepository closedQuestionRepository;

    public ClosedQuestionDto saveClosedQuestion(ClosedQuestionDto closedQuestionDto){
        ClosedQuestion closedQuestion = ClosedQuestionMapper.map(closedQuestionDto);
        ClosedQuestion savedClosedQuestion = closedQuestionRepository.save(closedQuestion);
        return ClosedQuestionMapper.map(savedClosedQuestion);
    }


}
