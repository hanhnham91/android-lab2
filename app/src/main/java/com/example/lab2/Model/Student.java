package com.example.lab2.Model;


public class Student {
    private String studentId;
    private String studentName;
    private String studentScore;
    public Student(String studentId, String studentName, String studentScore){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentScore=studentScore;
    }

    public String getStudentId(){
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public  String getStudentScore(){
        return studentScore;
    }
}

