package com.onlineQuiz.Online.Quiz.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
    String uid;
    String username;
    String email;
    String photoUrl;

    public Student(String studentId, String studentName, String studentEmail, String photoUrl) {
        this.uid = studentId;
        this.username = studentName;
        this.email = studentEmail;
        this.photoUrl = photoUrl;
    }
    public  Student(){}

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
