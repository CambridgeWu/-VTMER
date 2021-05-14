package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.StudentDao;
import com.cambridge.StuManager.po.Course;

import java.util.List;

public class StudentService {
    StudentDao studentDao=new StudentDao();

    public List<Course> FindCourse(String contend){
        return studentDao.FindCourse(contend);
    }

    public boolean cancel(String student){
        return studentDao.cancel(student);
    }
}
