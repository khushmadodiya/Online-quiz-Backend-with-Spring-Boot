package com.onlineQuiz.Online.Quiz.controller;

import com.onlineQuiz.Online.Quiz.model.Marks;
import com.onlineQuiz.Online.Quiz.repo.MarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MarksController {
    @Autowired
    MarksRepo marksRepo;
    @PostMapping("/marks")
    String insertRecordInMarks(@RequestBody Marks marks){
       return marksRepo.inserRecoderInMarks(marks);
    }

    @GetMapping("/marks/{studentId}")
    List<Marks> getMarksOfstudent(@PathVariable("studentId") String studentId){
        return  marksRepo.getMarksbystIdAndQuizId(studentId);
    }

}
