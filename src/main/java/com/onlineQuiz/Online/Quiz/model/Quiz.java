package com.onlineQuiz.Online.Quiz.model;

public class Quiz {
    String quizId;
    String quizTitle;
    String subName;
//    String studentId;
    String facultyId;

    public Quiz(String quizId, String quizTitle, String subName, String studentId, String facultyId) {
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.subName = subName;
//        this.studentId = studentId;
        this.facultyId = facultyId;
    }
    public Quiz(){}

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getQuizId() {
        return quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public String getSubName() {
        return subName;
    }

//    public String getStudentId() {
//        return studentId;
//    }

    public String getFacultyId() {
        return facultyId;
    }
}
