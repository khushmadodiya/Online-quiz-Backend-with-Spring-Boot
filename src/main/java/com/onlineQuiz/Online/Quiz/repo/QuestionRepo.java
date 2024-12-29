package com.onlineQuiz.Online.Quiz.repo;

import com.onlineQuiz.Online.Quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class QuestionRepo {
    @Autowired
    JdbcTemplate template;
    public String createQuestion(Question question){
        String sql = "insert into question values(?,?,?,?,?,?,?,?)";
        int row = template.update(sql,question.getQuestionId(),question.getQuestionName(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4(),question.getAns(),question.getQuizId());
        if(row>0){
            return "success";
        }
        else{
            return "Failed to add Question";
        }
    }

    public String updateQuestion(Question question){
        String sql = "update question SET questionName = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, ans = ?, quizId = ?  where questionId = ?";
        int row = template.update(sql,question.getQuestionName(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4(),question.getAns(),question.getQuizId(),question.getQuestionId());
        if(row>0){
            return "success";
        }
        else{
            return "Failed to Update Question";
        }
    }

    public String deleteQuestion(String questionId){
        String sql = "delete from question where questionId = ?";
        int row = template.update(sql,questionId);
        if(row>0){
            return "success";
        }
        else{
            return "Failed to delete Question";
        }
    }

    public List<Question> fetchAllQuestionsById(String quizId) {
        String sql = "select * from question where quizId = ?";
        RowMapper<Question> mapper = new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question q = new  Question();
                q.setQuestionId(rs.getString(1));
                q.setQuestionName(rs.getString(2));
                q.setOption1(rs.getString(3));
                q.setOption2(rs.getString(4));
                q.setOption3(rs.getString(5));
                q.setOption4(rs.getString(6));
                q.setAns(rs.getString(7));
                q.setQuizId(rs.getString(8));
                return q;
            }
        };
     return    template.query(sql,mapper,quizId);
    }
}
