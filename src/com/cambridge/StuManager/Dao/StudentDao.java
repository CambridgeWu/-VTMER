package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;
import com.cambridge.StuManager.po.Course;
import com.mysql.cj.xdevapi.DbDoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    //模糊查询课程
    public List<Course> FindCourse(String contend){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Course> courses=new ArrayList<Course>();
        Course course=new Course();

        String sql="select * from course where coursename like '%"+contend+"%' and student='NULL'" ;
        conn= DButils.getConnection();
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

    //注销账号
    public boolean cancel(String student){
        //注销登录，所选课程
        Connection conn=null;
        PreparedStatement ps=null;
        boolean result=false;

        StringBuilder sql=new StringBuilder();
        sql.append("delete from stulogin where name=?");
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql.toString());
            ps.setString(1,student);
            int count=ps.executeUpdate();
            if(count>=1){
                sql.setLength(0);
                sql.append("delete from course where student=?");
                ps=conn.prepareStatement(sql.toString());
                ps.setString(1,student);
                count=ps.executeUpdate();
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(ps,conn);
        }
        return result;
    }
}
