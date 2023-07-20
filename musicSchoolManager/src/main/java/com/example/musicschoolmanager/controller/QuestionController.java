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


    @GetMapping("/getDatabaseQuestions")
    public String getAllQuestionsFromDatabase(Model model){
        List<QuestionDto> question = questionService.findAllQuestions();
        model.addAttribute("question", question);
        return "add-database-questions";
    }

    //TODO KTO WIE CO Z TYM ZREOBIC ?????
/*    @PostMapping("/addChooseQuestion")
    public String addQuestionToExamFromDatabase(@RequestBody List<QuestionDto> selectedQuestions,
                                                @RequestBody Long examId){
        ExamDto exam = examService.findExamById(examId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        exam.setQuestions(selectedQuestions);


        return "redirect:";
    }*/

    @GetMapping("/chooseQuestionType")
    public String chooseQuestionType(){
        return "choose-question-type";
    }


    //TODO Get Mapping for Questions
    @GetMapping("/openQuestion")
    public String createOpenQuestion(Model model){
        model.addAttribute("question", new OpenQuestionDto());
        return "open-question";
    }

    @GetMapping("/closedQuestion")
    public String createClosedQuestion(Model model){
        model.addAttribute("question", new ClosedQuestionDto());
        return "closed-question";
    }



    //TODO Post Method for Questions
    @PostMapping("/saveOpenQuestion")
    public String saveOpenQuestion(@ModelAttribute("question") OpenQuestionDto openQuestionDto,
                                   @RequestParam(value = "text") String text,
                                   @RequestParam(value = "points") Integer points,
                                   @RequestParam(value = "answerKey") String answerKey) {
        questionService.createQuestion(openQuestionDto);
        return "redirect:/exam/examView";
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