package com.example.musicschoolmanager.controller;

import com.example.musicschoolmanager.model.Dto.ClosedQuestionDto;
import com.example.musicschoolmanager.model.Dto.OpenQuestionDto;
import com.example.musicschoolmanager.model.Dto.QuestionDto;
import com.example.musicschoolmanager.service.ExamService;
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
    private final ExamService examService;

    @GetMapping("/getDatabaseQuestions/{examId}")
    public String getAllQuestionsFromDatabase(@PathVariable Long examId, Model model){
        List<QuestionDto> questionDtos = questionService.findAllQuestions();
        model.addAttribute("question", questionDtos);
        model.addAttribute("examId", examId);
        return "add-database-questions";
    }

    @GetMapping("/chooseQuestionType/{examId}")
    public String chooseQuestionType(@PathVariable Long examId, Model model){
        model.addAttribute("examId", examId);
        return "choose-question-type";
    }

    @GetMapping("/error")
    public String doesntExistsQuestionInDatabase(){
        return "doesnt-exsists-question";
    }


    //TODO Get Mapping for Questions
    @GetMapping("/createOpenQuestion")
    public String createOpenQuestion(@RequestParam Long examId, Model model){
        model.addAttribute("question", new OpenQuestionDto());
        model.addAttribute("examId", examId);
        return "open-question";
    }

    @GetMapping("/createClosedQuestion")
    public String createClosedQuestion(Model model){
        model.addAttribute("question", new ClosedQuestionDto());
        return "closed-question";
    }


    //TODO Post Method for Questions
    @PostMapping("/{examId}/saveOpenQuestion")
    public String saveOpenQuestion(@ModelAttribute("question") OpenQuestionDto openQuestionDto,
                                   @PathVariable(value = "examId") Long examId,
                                   @RequestParam(value = "text") String text,
                                   @RequestParam(value = "points") Integer points,
                                   @RequestParam(value = "answerKey") String answerKey) {
        QuestionDto questionDto = questionService.createQuestion(openQuestionDto);
        return "redirect:/exam/{examId}/addNewQuestionToExam/" + questionDto.getId();
    }

    @PostMapping("/saveClosedQuestion")
    public String saveClosedQuestion(@ModelAttribute("question") ClosedQuestionDto closedQuestionDto,
                                     @RequestParam(value = "text") String text,
                                     @RequestParam(value = "points") Integer points,
                                     @RequestParam(value = "answers") List<String> answers,
                                     @RequestParam(value = "correctAnswers") List<String> correctAnswers){
        questionService.createQuestion(closedQuestionDto);
        return "redirect:/exam/examView";
    }
}