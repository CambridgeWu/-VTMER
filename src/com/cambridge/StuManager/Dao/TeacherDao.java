package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;
import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.po.TeacherLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    //将教师添加的课程交由管理员审核==添加到一个中间过渡的数据库表
    public boolean addCourse(String teacher,String coursename,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="insert into teacourse (teacher,coursename,classroom,time) values(?,?,?,?)";
        conn= DButils.getConnection();
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

    //查询所有教师添加的课程供管理员审核
    public List<Course> FindAllCourse(){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<Course> courses=new ArrayList<Course>();
        Course course=new Course();
        conn= DButils.getConnection();
        String sql="select * from teacourse";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String teacher=rs.getString("teacher");
                String coursename=rs.getString("coursename");
                String classroom=rs.getString("classroom");
                String time=rs.getString("time");

                course.setTeacher(teacher);
                course.setCoursename(coursename);
                course.setClassroom(classroom);
                course.setTime(time);
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return courses;
    }

    //教师账号注销==先转移到中间过渡的tcancel表中待管理员审核完毕后再注销
    public boolean TeacherLoginCancel(String name,String account,String password){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="insert into tcancel (name,account,password) values(?,?,?)";
        conn= DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,account);
            ps.setString(3,password);
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

    //查询所有教师注销的账号
    public List<TeacherLogin> FindAllTeacherCancel(){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<TeacherLogin> cancels=new ArrayList<TeacherLogin>();
        TeacherLogin cancel=new TeacherLogin();
        conn= DButils.getConnection();
        String sql="select * from tcancel";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                String account=rs.getString("account");
                String password=rs.getString("password");

                cancel.setName(name);
                cancel.setAccount(account);
                cancel.setPassword(password);

                cancels.add(cancel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return cancels;
    }
}
