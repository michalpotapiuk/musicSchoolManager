package com.example.musicschoolmanager.service;

import com.example.musicschoolmanager.model.Dto.*;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.repository.ClosedQuestionRepository;
import com.example.musicschoolmanager.repository.OpenQuestionRepository;
import com.example.musicschoolmanager.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final OpenQuestionRepository openQuestionRepository;
    private final ClosedQuestionRepository closedQuestionRepository;

    public Set<Question> findAllQuestionsById(Set<Long> id) {
        return questionRepository.findAllById(id).stream().collect(Collectors.toSet());
    }

    public QuestionDto createQuestion(QuestionDto questionDto){
        Question question = QuestionDtoMapper.map(questionDto);
        Question savedQuestion = questionRepository.save(question);
        return QuestionDtoMapper.map(savedQuestion);
    }

    public List<QuestionDto> findAllQuestions(){
        return questionRepository.findAll().stream()
                .map(QuestionDtoMapper::map)
                .toList();
    }

    public QuestionDto findQuestionById(Long id){
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        Question question = optionalQuestion.get();
        return QuestionDtoMapper.map(question);

    }
    public boolean checkIfQuestionExists(){
        return !questionRepository.findAll().isEmpty();
    }
}
