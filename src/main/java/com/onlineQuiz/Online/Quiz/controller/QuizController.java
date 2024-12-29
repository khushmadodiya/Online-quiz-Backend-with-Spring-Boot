package com.onlineQuiz.Online.Quiz.controller;

import com.onlineQuiz.Online.Quiz.model.Faculty;
import com.onlineQuiz.Online.Quiz.model.Quiz;
import com.onlineQuiz.Online.Quiz.repo.FacultyRepo;
import com.onlineQuiz.Online.Quiz.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class QuizController {
    @Autowired
    QuizRepo quizRepo ;

//    @GetMapping("/quiz")
//    List<Quiz> show(){
//        List<Quiz> quizes= quizRepo.findAll();
//        return  quizes;
//    }

    @PostMapping("{facultyId}/quiz")
    public String saveQuiz(@RequestBody Quiz quiz,@PathVariable("facultyId") String facultyId){
        System.out.println(quiz.getQuizId());
        System.out.println(quiz.getQuizTitle());
        System.out.println(quiz.getFacultyId());
        System.out.println(quiz.getSubName());
        String res;
        if(quizRepo.isFacultyExist(facultyId)) {
            res = quizRepo.createQuiz(quiz);
        }
        else {
            res = "Faculty is not Exist";
        }
        return  res;
    }

    @GetMapping("/{facultyId}/quiz/list")
    public  List<Quiz> quizList(@PathVariable("facultyId") String id){
        System.out.println("This is faculty Id"+id);
        return  quizRepo.findAllQuizzesByFacultyId(id);
    }
    @GetMapping("/quiz/{id}")
    public  String deleteQuiz(@PathVariable("id") String quizId){
        String res = quizRepo.deleteQuiz(quizId);
        return  res;
    }

}
