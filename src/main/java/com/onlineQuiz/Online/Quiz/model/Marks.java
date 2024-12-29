package com.onlineQuiz.Online.Quiz.model;

public class Marks {
    String marksId;
    String marksObtained;
    boolean status;
    String quizId;
    String studentId;

    public Marks(String marksId, String marksObtained, boolean status, String quizId, String studentId) {
        this.marksId = marksId;
        this.marksObtained = marksObtained;
        this.status = status;
        this.quizId = quizId;
        this.studentId = studentId;
    }
    public  Marks(){}

    public String getMarksId() {
        return marksId;
    }

    public void setMarksId(String marksId) {
        this.marksId = marksId;
    }

    public String getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(String marksObtained) {
        this.marksObtained = marksObtained;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
