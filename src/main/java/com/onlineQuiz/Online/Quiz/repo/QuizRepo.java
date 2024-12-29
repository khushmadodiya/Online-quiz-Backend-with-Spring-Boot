package com.onlineQuiz.Online.Quiz.repo;
import com.onlineQuiz.Online.Quiz.model.Faculty;
import com.onlineQuiz.Online.Quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class QuizRepo {

    JdbcTemplate template;
    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public boolean isFacultyExist(String facultyId){
        String sql = "select * from faculty where facultyId= ? ";

       return  !template.query(sql, (rs, rowNum) -> {
           Faculty s = new Faculty();
           s.setUid(rs.getString(1));
           s.setUsername(rs.getString(2));
           s.setEmail(rs.getString(3));
           System.out.println(s);
           return s;
       }, facultyId).isEmpty();
    }


    public  String  createQuiz(Quiz quiz){
        String sql = "insert into quiz(quizId,quizTitle,subName, facultyId) values ( ?,?,?,?,?)";

       int row= template.update(sql,quiz.getQuizId(),quiz.getQuizTitle(),quiz.getSubName(),quiz.getFacultyId());
       if(row>0){
           System.out.println("saved");
           return "Success";
       }
       return  "some error occured";
    }


    public List<Quiz> findAllQuizzesByFacultyId(String Id){
        String sql = "select * from quiz where facultyId = ?";
        RowMapper<Quiz> mapper= new RowMapper<>(){
            @Override
            public  Quiz mapRow(ResultSet rs , int rowNum) throws SQLException {
                Quiz s = new Quiz();
                s.setQuizId(rs.getString(1));
                s.setQuizTitle(rs.getString(2));
                s.setSubName(rs.getString(3));
//                s.setStudentId(rs.getString(4));
                s.setFacultyId(rs.getString(5));
                return  s;
            };
        };

        return template.query(sql,mapper,Id);
    }

    public  String  deleteQuiz(String quizId){
        String sql = "delete from quiz where quizId = ?";

        int row= template.update(sql,quizId);
        if(row>0){
            System.out.println("saved");
            return "Success";
        }
        return  "some error occured";
    }

}
