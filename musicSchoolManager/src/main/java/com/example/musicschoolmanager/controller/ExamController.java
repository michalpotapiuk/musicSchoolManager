package com.example.musicschoolmanager.controller;


import com.example.musicschoolmanager.model.Dto.ExamDto;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.service.ExamService;
import com.example.musicschoolmanager.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        examService.createExam(examDto);
        if (submitButton.equals("database")) {
            return "redirect:/questions/getDatabaseQuestions";
        } else {
            return "redirect:/questions/chooseQuestionType";
        }
    }

    @PostMapping("/exams/{examId}/questions")
    public ResponseEntity<String> addQuestionToExam(
            @PathVariable Long examId,
            @RequestBody QuestionDto questionDto) {

        examService.addQuestionToExam(examId, questionDto);

        return ResponseEntity.ok("Question added to the exam.");
    }



}

