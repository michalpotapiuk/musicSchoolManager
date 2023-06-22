package com.example.musicschoolmanager.controller;

import com.example.musicschoolmanager.model.Dto.ClosedQuestionDto;
import com.example.musicschoolmanager.model.Dto.ExamDto;
import com.example.musicschoolmanager.model.Dto.OpenQuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.service.ClosedQuestionService;
import com.example.musicschoolmanager.service.ExamService;
import com.example.musicschoolmanager.service.OpenQuestionService;
import com.example.musicschoolmanager.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@SessionAttributes("questions")
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;
    private final OpenQuestionService openQuestionService;
    private final ClosedQuestionService closedQuestionService;
    private final ExamService examService;


    @GetMapping("/getDatabaseQuestions")
    public String getAllQuestionsFromDatabase(Model model){
        List<QuestionDto> question = questionService.findAllQuestions();
        model.addAttribute("question", question);
        return "add-database-questions";
    }

    @PostMapping("/addChooseQuestion")
    public String addQuestionToExamFromDatabase(@RequestBody List<QuestionDto> selectedQuestions,
                                                @RequestBody Long examId){
        ExamDto exam = examService.findExamById(examId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        //exam.setQuestionDtos(selectedQuestions);
        //examService.createExam()

        return "redirect:";
    }

    @GetMapping("/chooseQuestionType")
    public String chooseQuestionType(){
        return "choose-question-type";
    }

    @GetMapping("/openQuestion")
    public String createOpenQuestion(Model model){
        model.addAttribute("question", new OpenQuestionDto());
        return "open-question";
    }

    @PostMapping("/save")
    public String saveOpenQuestion(@ModelAttribute("question") OpenQuestionDto openQuestionDto,
                                   @RequestParam(value = "text") String text,
                                   @RequestParam(value = "points") String points,
                                   @RequestParam(value = "answerKey") String answerKey,
                                   @RequestParam(required = false, defaultValue = "create") String submitButton) {
        openQuestionService.saveOpenQuestion(openQuestionDto);
        return "redirect:/";
        }


    @PostMapping("/add/openQuestion")
    ResponseEntity<OpenQuestionDto> saveOpenQuestion(@RequestBody OpenQuestionDto openQuestionDto){
        openQuestionService.saveOpenQuestion(openQuestionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add/closedQuestion")
    ResponseEntity<ClosedQuestionDto> saveClosedQuestion(@RequestBody ClosedQuestionDto closedQuestionDto){
        closedQuestionService.saveClosedQuestion(closedQuestionDto);
        return ResponseEntity.ok().build();
    }
}