package com.cambridge.StuManager.po;

public class Exam {
    private String student;
    private String teacher;
    private String examname;
    private String classroom;
    private String time;
    private String condition;
    private String grade;

    public Exam() {
    }

    public Exam(String student,String teacher, String examname, String classroom, String time, String condition, String grade) {
        this.student=student;
        this.teacher = teacher;
        this.examname = examname;
        this.classroom = classroom;
        this.time = time;
        this.condition = condition;
        this.grade = grade;
    }

    public Exam(String teacher, String examname, String classroom, String time, String condition, String grade) {
        this.teacher = teacher;
        this.examname = examname;
        this.classroom = classroom;
        this.time = time;
        this.condition = condition;
        this.grade = grade;
    }

    public Exam(String teacher, String examname, String classroom, String time, String condition) {
        this.teacher = teacher;
        this.examname = examname;
        this.classroom = classroom;
        this.time = time;
        this.condition = condition;
    }

    public Exam(String teacher, String examname, String classroom, String time) {
        this.teacher = teacher;
        this.examname = examname;
        this.classroom = classroom;
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getExamname() {
        return examname;
    }

    public void setExamname(String examname) {
        this.examname = examname;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
