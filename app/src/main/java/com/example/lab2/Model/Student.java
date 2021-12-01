package com.example.lab2.Model;


import androidx.room.ColumnInfo;

public class Student {
    private String studentId;
    private String studentName;
    private String studentGender;
    private String studentEmail;
    private String studentTel;
    private String studentDob;
    private float finalScore;

    public Student(String studentId, String studentName, String studentGender, String studentEmail, String studentTel, String studentDob, float finalScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentEmail = studentEmail;
        this.studentTel = studentTel;
        this.studentDob = studentDob;
        this.finalScore = finalScore;
    }

    public String getStudentId() {        return studentId;    }

    public String getStudentName() {        return studentName;    }

    public String getStudentGender() {        return studentGender;    }

    public String getStudentEmail() {        return studentEmail;    }

    public String getStudentTel() {        return studentTel;    }

    public String getStudentDob() {        return studentDob;    }

    public String getFinalScore() {        return String.valueOf(finalScore);    }
}

