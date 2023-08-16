package com.example.musicschoolmanager.controller;


import com.example.musicschoolmanager.model.Dto.ExamDto;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.service.ExamService;
import com.example.musicschoolmanager.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@SessionAttributes("exam")
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;
    private final QuestionService questionService;

    @GetMapping("/add")
    public String addExam(Model model) {
        model.addAttribute("exam", new ExamDto());
        return "add-exam";
    }

    @GetMapping("/chooseQuestionsTypeToAdd/{examId}")
    public String chooseTypeOfNewQuestion(@PathVariable Long examId, Model model){
        model.addAttribute("exam", examService.findById(examId));
        return "choose-questions-type-to-add";
    }

    @GetMapping("/examView/{examId}")
    public String summaryExamView(@PathVariable Long examId, Model model){
        model.addAttribute("examId", examId);
        Set<QuestionDto> questionDtos = questionService.findAllExamsQuestions(examId);
        if (questionDtos != null) {
            model.addAttribute("questions", questionDtos);
        }
        model.addAttribute("exam", examService.findById(examId));
        return "summary-exam";
    }

    @PostMapping("/save")
    public String saveTemplateExam(@ModelAttribute("exam") ExamDto examDto,
                                   @RequestParam(required = false, defaultValue = "default") String submitButton) {
        ExamDto exam = examService.createExam(examDto);
        if (submitButton.equals("database")) {
            if (questionService.checkIfQuestionExists()){
                return "redirect:/questions/getDatabaseQuestions/" + exam.id;
            }else{
                return "redirect:/questions/error/" + exam.id;
            }
        } else {
            return "redirect:/questions/chooseQuestionType/" + exam.id;
        }
    }

    @PostMapping("/{examId}/addQuestionToExam")
    public String addQuestionFromDatabaseToExam(
            @PathVariable Long examId,
            @RequestParam(required = false) Set<Long> selectedQuestions) {

        if (selectedQuestions == null || selectedQuestions.isEmpty()) {
            return String.format("redirect:/exam/examView/%s?noQuestionsSelected=true", examId);
        }

        ExamDto examDto = examService.findById(examId);
        Set<QuestionDto> questionsDto = questionService.findAllQuestionsById(selectedQuestions);

        examService.addQuestionToExam(examDto, questionsDto);

        return "redirect:/exam/examView/" + examId;
    }


    @GetMapping("/{examId}/addNewQuestionToExam/{questionId}")
    public String addCreatedQuestionToExam(
            @PathVariable(value = "examId") Long examId,
            @PathVariable(value = "questionId") Long id){
        ExamDto examDto = examService.findById(examId);

        QuestionDto selectedQuestions = questionService.findQuestionById(id);
        examService.addNewQuestionToExam(examDto,selectedQuestions);

        return "redirect:/exam/examView/" + examId;
    }

    @GetMapping("/created")
    public String createdExam(){
        return "created-exam";
    }
}