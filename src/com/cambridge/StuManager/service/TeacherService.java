package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.TeacherDao;
import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.po.TeacherLogin;

import java.util.List;

public class TeacherService {
    TeacherDao teacherDao=new TeacherDao();

    //添加课程
    public boolean addCourse(Course course){
        return teacherDao.addCourse(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //查询所有教师添加的课程
    public List<Course> FindAllCourse(){
        return teacherDao.FindAllCourse();
    }

    //教师账号注销
    public boolean TeacherLoginCancel(TeacherLogin teacherLogin){
        return teacherDao.TeacherLoginCancel(teacherLogin.getName(),teacherLogin.getAccount(),teacherLogin.getPassword());
    }

    //查询所有教师注销的账号
    public List<TeacherLogin> FindAllTeacherCancel(){
        return teacherDao.FindAllTeacherCancel();
    }

}
