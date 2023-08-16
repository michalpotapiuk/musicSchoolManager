package com.example.musicschoolmanager.controller;

import com.example.musicschoolmanager.model.Dto.ClosedQuestionDto;
import com.example.musicschoolmanager.model.Dto.OpenQuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("question")
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/getDatabaseQuestions/{examId}")
    public String getAllQuestionsFromDatabase(@PathVariable Long examId, Model model){
        List<QuestionDto> questionDtos = questionService.findAllQuestions();
        if (questionDtos.isEmpty()){
            return "redirect:/questions/error/" + examId;
        }
        model.addAttribute("question", questionDtos);
        model.addAttribute("examId", examId);
        return "add-database-questions";
    }

    @GetMapping("/chooseQuestionType/{examId}")
    public String chooseQuestionType(@PathVariable Long examId, Model model){
        model.addAttribute("examId", examId);
        return "choose-question-type";
    }

    @GetMapping("/error/{examId}")
    public String doesntExistsQuestionInDatabase(@PathVariable Long examId,Model model){
        model.addAttribute("examId", examId);
        return "doesnt-exsists-question";
    }

    @GetMapping("/createOpenQuestion")
    public String createOpenQuestion(@RequestParam Long examId, Model model){
        model.addAttribute("question", new OpenQuestionDto());
        model.addAttribute("examId", examId);
        return "open-question";
    }

    @GetMapping("/createClosedQuestion")
    public String createClosedQuestion(@RequestParam Long examId,Model model){
        model.addAttribute("question", new ClosedQuestionDto());
        model.addAttribute("examId", examId);
        return "closed-question";
    }

    @PostMapping("/{examId}/saveOpenQuestion")
    public String saveQuestion(@ModelAttribute("question") OpenQuestionDto openQuestionDto,
                                   @PathVariable(value = "examId") Long examId) {
        QuestionDto questionDto = questionService.createQuestion(openQuestionDto);
        return String.format("redirect:/exam/%s/addNewQuestionToExam/%s", examId, questionDto.getId());
    }

    @PostMapping("/{examId}/saveClosedQuestion")
    public String saveQuestion(@ModelAttribute("question") ClosedQuestionDto closedQuestionDto,
                                     @PathVariable(value = "examId") Long examId){
        QuestionDto questionDto = questionService.createQuestion(closedQuestionDto);
        return String.format("redirect:/exam/%s/addNewQuestionToExam/%s", examId, questionDto.getId());
    }
}