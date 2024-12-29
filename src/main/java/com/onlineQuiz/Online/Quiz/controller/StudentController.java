package com.onlineQuiz.Online.Quiz.controller;

import com.onlineQuiz.Online.Quiz.model.Faculty;
import com.onlineQuiz.Online.Quiz.model.Marks;
import com.onlineQuiz.Online.Quiz.model.Quiz;
import com.onlineQuiz.Online.Quiz.model.Student;
import com.onlineQuiz.Online.Quiz.repo.MarksRepo;
import com.onlineQuiz.Online.Quiz.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo ;
    @Autowired
    MarksRepo marksRepo;
    @GetMapping("student/{id}")
    List<Student> greet(@PathVariable("id") String id){
       List<Student> students= studentRepo.getStudentWithId(id);
        return  students;
    }
    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student.getUid());
        String res = studentRepo.save(student);
        return  res;
    }

    @GetMapping("student/quiz/{studentId}")
    public List<Quiz> getQuizzesByStudentId(@PathVariable("studentId") String studentId){
        return  studentRepo.findListOfQuizzesbyStudent(studentId);
    }

    @PostMapping("student/quiz/submit")
    public  String  submitQuiz(@RequestBody Marks marks){
        return  marksRepo.updateMarksOfStudent(marks);
    }

    @GetMapping("student/faculty/{facultyId}")
    public String getFacultyName(@PathVariable("facultyId") String facultyId){
        String name = studentRepo.getFacultyWithId(facultyId).getUsername();
        return  name;
    }

    @GetMapping("student/question/count/{quizId}")
    public  int getNoOfQuestionINQuiz(@PathVariable("quizId") String quizId){
        return  studentRepo.getNoOfQuestionInQuizByQuizId(quizId);
    }

}
