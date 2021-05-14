package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.CourseDao;
import com.cambridge.StuManager.po.Course;

import java.util.List;

public class CourseService {
    CourseDao coursedao=new CourseDao();

    //查询所有课程
    public List<Course> FindAllCourse(){
        return coursedao.FindAllCourse();
    }

    //教师设置课程确认
    public boolean addCourse(Course course){
        return coursedao.addCourse(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //确认添加课程后删除记录
    public boolean deleteCourse(Course course){
        return coursedao.deleteCourse(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //学生课程添加
    public boolean stuCourseAdd(Course course){
        return coursedao.stuCourseAdd(course.getStudent(),course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //管理员修改课程
    public boolean ModifyCourse(Course course){
        return coursedao.ModifyCourse(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //管理员页面显示所有要添加的考试
    public List<Course> FindAllExam(){
        return coursedao.FindAllExam();
    }

    //根据学生姓名找到所有课程
    public List<String> FindAllCourseByStudent(String student){
        return coursedao.FindAllCourseByStudent(student);
    }

}
