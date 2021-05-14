package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;
import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.po.TeacherLogin;

import javax.lang.model.element.NestingKind;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    //打印可以选择的课程，既没有学生列的
    public List<Course> FindAllCourse(){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<Course> courseList=new ArrayList<Course>();
        conn= DButils.getConnection();
        String sql="select * from course where student='NULL'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Course course=new Course();
                String teacher=rs.getString("teacher");
                String coursename=rs.getString("coursename");
                String classroom=rs.getString("classroom");
                String time=rs.getString("time");

                course.setTeacher(teacher);
                course.setCoursename(coursename);
                course.setClassroom(classroom);
                course.setTime(time);

                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return courseList;
    }

    //管理员确认添加课程
    public boolean addCourse(String teacher,String coursename,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="insert into course (student,teacher,coursename,classroom,time) values('NULL',?,?,?,?)";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            ps.setString(2,coursename);
            ps.setString(3,classroom);
            ps.setString(4,time);
            int count=ps.executeUpdate();
            if(count==1){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(ps,conn);
        }
        return result;
    }

    //管理员添加课程后的删除
    public boolean deleteCourse(String teacher,String coursename,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from teacourse where teacher=? and coursename=? and classroom=? and time=?";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            ps.setString(2,coursename);
            ps.setString(3,classroom);
            ps.setString(4,time);
            int count=ps.executeUpdate();
            if(count==1){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(ps,conn);
        }
        return result;
    }

    //学生课程添加
    public boolean stuCourseAdd(String student,String teacher,String coursename,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="insert into course (student,teacher,coursename,classroom,time) values(?,?,?,?,?)";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,student);
            ps.setString(2,teacher);
            ps.setString(3,coursename);
            ps.setString(4,classroom);
            ps.setString(5,time);
            int count=ps.executeUpdate();
            if(count==1){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(ps,conn);
        }
        return result;
    }

    //管理员修改课程
    public boolean ModifyCourse(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="update teacourse set classroom=?,time=? where teacher=? and examname=?";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,classroom);
            ps.setString(2,time);
            ps.setString(3,teacher);
            ps.setString(4,examname);
            int count=ps.executeUpdate();
            if(count==1){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(ps,conn);
        }
        return result;
    }

    //管理员页面显示所有要添加的考试
    public List<Course> FindAllExam(){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<Course> courseList=new ArrayList<Course>();
        conn= DButils.getConnection();
        String sql="select * from teaexam";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Course course=new Course();
                String teacher=rs.getString("teacher");
                String examname=rs.getString("examname");
                String classroom=rs.getString("classroom");
                String time=rs.getString("time");

                course.setTeacher(teacher);
                course.setCoursename(examname);
                course.setClassroom(classroom);
                course.setTime(time);

                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return courseList;
    }

    //根据学生姓名找到所有课程
    public List<String> FindAllCourseByStudent(String student){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<String> courseList=new ArrayList<String>();
        conn= DButils.getConnection();
        String sql="select * from course where student=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,student);
            rs=ps.executeQuery();
            while(rs.next()){
                String course=rs.getString("coursename");
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return courseList;
    }

}
