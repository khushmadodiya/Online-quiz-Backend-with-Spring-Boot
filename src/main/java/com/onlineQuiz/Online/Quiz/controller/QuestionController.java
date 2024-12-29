package com.onlineQuiz.Online.Quiz.controller;

import com.onlineQuiz.Online.Quiz.model.Question;
import com.onlineQuiz.Online.Quiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class QuestionController {
    @Autowired
    QuestionRepo questionRepo;
    @PostMapping("/question")
    String AddQuestionToQuiz(@RequestBody Question question){
      return  questionRepo.createQuestion(question);
    }

    @GetMapping("/question/{quizId}")
    List<Question> fetchAllQuestionByQuizId(@PathVariable("quizId") String quizId){
//        System.out.println("This is quiz Id "+ quizId);
        return  questionRepo.fetchAllQuestionsById(quizId);
    }

    @PostMapping("/question/update")
    String updateQuestion(@RequestBody Question question){
        return  questionRepo.updateQuestion(question);
    }

    @GetMapping("/question/delete/{questionId}")
    String deleteQuestion(@PathVariable("questionId") String questionId){
        System.out.println("This is questionId "+questionId);
        return  questionRepo.deleteQuestion(questionId);
    }
}
