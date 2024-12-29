package com.onlineQuiz.Online.Quiz.repo;

import com.onlineQuiz.Online.Quiz.model.Faculty;
import com.onlineQuiz.Online.Quiz.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FacultyRepo {
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public  String  save(Faculty faculty){
        String sql = "insert into faculty(facultyId,facultyName,facultyEmail,facultyPhotoUrl) values ( ?,?,?,?)";

        template.update(sql,faculty.getUid(),faculty.getUsername(),faculty.getEmail(), faculty.getPhotoUrl());
        System.out.println("Saved");
        return "Success";
    }
    public List<Faculty> getFacultyWithId(String id){
        String sql = "select * from faculty where facultyId = ?";
        RowMapper<Faculty> mapper= new RowMapper<>(){
            @Override
            public  Faculty mapRow(ResultSet rs , int rowNum) throws SQLException {
                Faculty s = new Faculty();
                s.setUid(rs.getString(1));
                s.setUsername(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setPhotoUrl(rs.getString(4));
                return  s;
            };
        };

        return template.query(sql,mapper,id);
    }
}
