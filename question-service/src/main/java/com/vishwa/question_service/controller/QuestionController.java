package com.vishwa.question_service.controller;

import com.vishwa.question_service.model.Question;
import com.vishwa.question_service.model.QuestionWrapper;
import com.vishwa.question_service.model.Response;
import com.vishwa.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
           List<Question> questionsByCategory = questionService.getQuestionsByCategory(category);
           return new ResponseEntity<>(questionsByCategory, HttpStatus.OK);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
        List<Integer> selectedQuestionNums= questionService.getQuestionsForQuiz(categoryName, numQuestions);
        return new ResponseEntity<>(selectedQuestionNums, HttpStatus.OK);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
        System.out.println(environment.getProperty("local.server.port"));
        List<QuestionWrapper> getQuestionsByNum= questionService.getQuestionsFromId(questionIds);
        return new ResponseEntity<>(getQuestionsByNum, HttpStatus.OK);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        Integer score= questionService.getScore(responses);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
