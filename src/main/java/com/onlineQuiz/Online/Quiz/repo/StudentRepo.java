package com.onlineQuiz.Online.Quiz.repo;

import com.onlineQuiz.Online.Quiz.model.Faculty;
import com.onlineQuiz.Online.Quiz.model.Quiz;
import com.onlineQuiz.Online.Quiz.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class StudentRepo {
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public  String  save(Student student){
        String sql = "insert into student(studentId,studentName,studentEmail,studentPhotoUrl) values ( ?,?,?,?)";

        template.update(sql,student.getUid(),student.getUsername(),student.getEmail(), student.getPhotoUrl());
        System.out.println("Saved");
        return "Success";
    }
    public List<Student> getStudentWithId(String id){
        String sql = "select * from student where studentId = ?";
        RowMapper<Student> mapper= new RowMapper<>(){
            @Override
            public  Student mapRow(ResultSet rs , int rowNum) throws SQLException {
                Student s = new Student();
                s.setUid(rs.getString(1));
                s.setUsername(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setPhotoUrl(rs.getString(4));
                return  s;
            };
        };
        return template.query(sql,mapper,id);
    }

//    public Quiz joinQuizbyId(String quizId){
//        String sql = "select * from quiz where quizId = ?";
//        RowMapper<Quiz> quizRowMapper = new RowMapper<Quiz>() {
//            @Override
//            public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Quiz q  = new Quiz();
//                q.setQuizId(rs.getString(1));
//                q.setQuizTitle(rs.getString(2));
//                q.setSubName(rs.getString(3));
//                q.setFacultyId(rs.getString(5));
//                return  q;
//            }
//
//        };
//
//       return template.queryForObject(sql,quizRowMapper,quizId);
//
//    }

   public List<Quiz> findListOfQuizzesbyStudent(String studentId){
        String sql = "select q.quizId,q.quizTitle,q.subName,q.facultyId from quiz q inner join marks m where m.quizId = q.quizId and m.studentId = ?";
        RowMapper<Quiz> mapper = new RowMapper<Quiz>() {
            @Override
            public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
                Quiz q = new Quiz();
                q.setQuizId(rs.getString(1));
                q.setQuizTitle(rs.getString(2));
                q.setSubName(rs.getString(3));
                q.setFacultyId(rs.getString(4));
                return  q;
            }
        };
        return template.query(sql,mapper,studentId);
    }

    public Faculty getFacultyWithId(String facultyId){
        String sql = "select facultyName from faculty where facultyId = ?";
        RowMapper<Faculty> mapper = new RowMapper<Faculty>() {
            @Override
            public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
                Faculty f = new Faculty();
                f.setUsername(rs.getString(1));
                return  f;
            }
        };
        return template.queryForObject(sql,mapper,facultyId);
    }
    public Integer getNoOfQuestionInQuizByQuizId(String quizId){
        String sql = "select count(quizId) from question where quizId = ?";
        return template.queryForObject(sql, Integer.class, quizId);
    }


}
