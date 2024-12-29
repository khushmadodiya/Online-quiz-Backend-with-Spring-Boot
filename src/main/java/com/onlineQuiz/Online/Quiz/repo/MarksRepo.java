package com.onlineQuiz.Online.Quiz.repo;

import com.onlineQuiz.Online.Quiz.model.Marks;
import com.onlineQuiz.Online.Quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class MarksRepo {
    @Autowired
    JdbcTemplate template;

    public boolean isQuizExist(Marks marks) {
        String sql = "select * from quiz where quizId= ? ";
        System.out.println("Quiz Id" + marks.getQuizId());
        return !template.query(sql, (rs, rowNum) -> {
            Quiz s = new Quiz();
            s.setQuizId(rs.getString(1));
            System.out.println(s);
            return s;
        }, marks.getQuizId()).isEmpty();
    }

    public String inserRecoderInMarks(Marks marks) {
        if (isQuizExist(marks)) {
            String sql = "insert into marks(marksId, quizId, studentId) values(?,?,?)";
            int row = template.update(sql, marks.getMarksId(), marks.getQuizId(), marks.getStudentId());
            if (row > 0) {
                return "success";
            }
            return "Failed to insert";
        }
        return "Quiz not Exist";
    }
    public String updateMarksOfStudent(Marks marks) {

            String sql = "update marks set marksObtained = ? , status = ? where quizId = ? and studentId=?";
            int row = template.update(sql, marks.getMarksObtained(), marks.isStatus(), marks.getQuizId(),marks.getStudentId());
            if (row > 0) {
                return "success";
            }
            return "Failed to update Marks";
    }

    public List<Marks> getMarksbystIdAndQuizId(String studentId){
        String sql = "select * from marks where studentId = ?";
        RowMapper<Marks> quizRowMapper = new RowMapper() {
            @Override
            public Marks mapRow(ResultSet rs, int rowNum) throws SQLException {
                Marks q  = new Marks();
                q.setMarksId(rs.getString(1));
                q.setMarksObtained(rs.getString(2));
                q.setStatus(rs.getBoolean(3));
                q.setQuizId(rs.getString(4));
                q.setStudentId(rs.getString(5));
                return  q;
            }

        };

       return template.query(sql,quizRowMapper,studentId);

    }

}
