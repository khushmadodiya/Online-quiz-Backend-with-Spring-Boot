package com.onlineQuiz.Online.Quiz.controller;

import com.onlineQuiz.Online.Quiz.model.Faculty;
import com.onlineQuiz.Online.Quiz.model.Student;
import com.onlineQuiz.Online.Quiz.repo.FacultyRepo;
import com.onlineQuiz.Online.Quiz.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class FacultyController {
    @Autowired
    FacultyRepo facultyRepo ;
    @GetMapping("/faculty/{id}")
    List<Faculty> greet(@PathVariable("id") String id){
        List<Faculty> faculties= facultyRepo.getFacultyWithId(id);
        return  faculties;
    }

    @PostMapping("/faculty")
    public String saveStudent(@RequestBody Faculty faculty){
        System.out.println(faculty.getUid());
        String res = facultyRepo.save(faculty);
        return  res;
    }

}
