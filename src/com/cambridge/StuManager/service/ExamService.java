package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.ExamDao;
import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.po.Exam;

import java.util.List;

public class ExamService {
    ExamDao examDao=new ExamDao();

    //教师申请添加考试
    public boolean TAddExam(Course course){
        return examDao.TAddExam(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //管理员确认添加考试
    public boolean ConfirmAdd(Course course){
        return examDao.ConfirmAdd(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //删除要添加的考试
    public boolean DeleteExam(Course course){
        return examDao.DeleteExam(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //管理员调整考试
    public boolean ModifyExam(Course course){
        return examDao.ModifyExam(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //根据考试科目查询考试==>打印出考试信息
    public Exam FindExamBycoursename(String examname){
        return examDao.FindExamBycoursename(examname);
    }

    //查询所有考试
    public List<Exam> FindAllExam(){
        return examDao.FindAllExam();
    }

    //管理员删除考试
    public boolean adminDeleteExam(Course course){
        return examDao.adminDeleteExam(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //管理员修改考试
    public boolean adminModifyExam(Course course){
        return examDao.adminModifyExam(course.getTeacher(),course.getCoursename(),course.getClassroom(),course.getTime());
    }

    //添加评分
    public boolean AddGrade(Exam exam){
        return examDao.AddGrade(exam.getTeacher(),exam.getExamname(),exam.getClassroom(),exam.getTime(),exam.getGrade());
    }

    //我的考试
    public List<Exam> MyExam(String teacher){
        return examDao.MyExam(teacher);
    }

    //考试结束
    public boolean finishExam(Exam exam){
        return examDao.finishExam(exam.getTeacher(),exam.getExamname(),exam.getClassroom(),exam.getTime());
    }
}
