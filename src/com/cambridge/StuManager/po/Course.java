package com.cambridge.StuManager.po;

public class Course {
    private String student;
    private String teacher;         //任课教师
    private String coursename;      //课程名
    private String classroom;       //教室
    private String time;            //时间   周一到周五在分为上下午，选择形式

    public Course(String teacher, String coursename, String classroom, String time) {
        this.teacher = teacher;
        this.coursename = coursename;
        this.classroom = classroom;
        this.time = time;
    }

    public Course(String student,String teacher, String coursename, String classroom, String time) {
        this.student=student;
        this.teacher = teacher;
        this.coursename = coursename;
        this.classroom = classroom;
        this.time = time;
    }

    public Course() {
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
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

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}
