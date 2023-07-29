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


    public OpenQuestionDto getOpenQuestionById(Long id){
        Optional<OpenQuestionDto> openQuestionDtoOptional = openQuestionRepository.findById(id)
                                                                .map(OpenQuestionDtoMapper::map);
        return openQuestionDtoOptional.get();
    }

    public QuestionDto createQuestion(QuestionDto questionDto){
        Question question = QuestionDtoMapper.map(questionDto);
        Question savedQuestion = questionRepository.save(question);
        return QuestionDtoMapper.map(savedQuestion);
    }

    public List<OpenQuestionDto> findAllOpenQuestions() {
        return openQuestionRepository.findAll().stream()
                .map(OpenQuestionDtoMapper::map)
                .toList();
    }

    public List<QuestionDto> findAllQuestions(){
        return questionRepository.findAll().stream()
                .map(QuestionDtoMapper::map)
                .toList();
    }

    public List<ClosedQuestionDto> findAllClosedQuestions() {
        return closedQuestionRepository.findAll().stream()
                .map(ClosedQuestionMapper::map)
                .toList();
    }
}
