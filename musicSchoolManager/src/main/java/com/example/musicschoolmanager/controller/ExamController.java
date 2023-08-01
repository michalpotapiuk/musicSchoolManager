package com.example.musicschoolmanager.controller;


import com.example.musicschoolmanager.model.Dto.ExamDto;
import com.example.musicschoolmanager.model.Dto.ExamDtoMapper;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDtoMapper;
import com.example.musicschoolmanager.model.Exam;
import com.example.musicschoolmanager.model.abstracts.Question;
import com.example.musicschoolmanager.service.ExamService;
import com.example.musicschoolmanager.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
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

    @GetMapping("/examView")
    public String summaryExamView(){
        return "exam-view";
    }

    @PostMapping("/save")
    public String saveTemplateExam(@ModelAttribute("exam") ExamDto examDto,
                                   @RequestParam(value = "category") String category,
                                   @RequestParam(value = "instrumentGroup") String instrumentGroup,
                                   @RequestParam(value = "examDate") String examDate,
                                   @RequestParam(required = false, defaultValue = "default") String submitButton) {
        ExamDto exam = examService.createExam(examDto);
        if (submitButton.equals("database")) {
            if (questionService.checkIfQuestionExists()){
                return "redirect:/questions/getDatabaseQuestions/" + exam.id;
            }else{
                return "redirect:/questions/error";
            }
        } else {
            return "redirect:/questions/chooseQuestionType/" + exam.id;
        }
    }

    @PostMapping("/{examId}/addQuestionToExam")
    public String addQuestionFromDatabaseToExam(
            @PathVariable(value = "examId") Long examId,
            @RequestParam("selectedQuestions") Set<Long> selectedQuestionIds) {

        Optional<Exam> optionalExam = examService.findById(examId);

        if (optionalExam.isPresent()) {
            Exam exam = optionalExam.get();
            Set<Question> selectedQuestions = questionService.findAllQuestionsById(selectedQuestionIds);
            exam.setQuestions(selectedQuestions);
            examService.addQuestionToExam(exam,selectedQuestions);
        }
        return "redirect:/exam/examView";
    }

    @GetMapping("/{examId}/addNewQuestionToExam/{questionId}")
    public String addCreatedQuestionToExam(
            @PathVariable(value = "examId") Long examId,
            @PathVariable(value = "questionId") Long id){
        Optional<Exam> optionalExam = examService.findById(examId);

        if (optionalExam.isPresent()) {
            Exam exam = optionalExam.get();
            QuestionDto selectedQuestions = questionService.findQuestionById(id);
            examService.addNewQuestionToExam(ExamDtoMapper.map(exam),selectedQuestions);
        }
        return "redirect:/exam/examView";
    }

}