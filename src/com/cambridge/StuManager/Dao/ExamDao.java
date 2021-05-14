package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;
import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.po.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDao {

    //教师申请添加考试
    public boolean TAddExam(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="insert into teaexam (teacher,examname,classroom,time) values(?,?,?,?)";
        conn= DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            ps.setString(2,examname);
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

    //管理员确认添加考试
    public boolean ConfirmAdd(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="insert into exam (student,teacher,examname,classroom,time,condi,grade) values('NULL',?,?,?,?,'正在考试','NULL')";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            ps.setString(2,examname);
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

    //删除要添加的考试
    public boolean DeleteExam(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from teaexam where teacher=? and examname=? and classroom=? and time=?";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            ps.setString(2,examname);
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

    //管理员调整考试
    public boolean ModifyExam(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="update teaexam set classroom=?,time=? where teacher=? and examname=?";
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

    //根据考试科目查询考试==>打印出考试信息
    public Exam FindExamBycoursename(String examname){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        Exam exams=new Exam();
        conn= DButils.getConnection();
        String sql="select * from exam where examname=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,examname);
            rs=ps.executeQuery();
            if(rs.next()){
                String teacher=rs.getString("teacher");
                String exam=rs.getString("examname");
                String classroom=rs.getString("classroom");
                String time=rs.getString("time");
                String condition=rs.getString("condi");
                String grade=rs.getString("grade");

                exams.setTeacher(teacher);
                exams.setExamname(examname);
                exams.setClassroom(classroom);
                exams.setTime(time);
                exams.setCondition(condition);
                exams.setGrade(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return exams;
    }

    //查询所有考试
    public List<Exam> FindAllExam(){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<Exam> examList=new ArrayList<Exam>();
        conn= DButils.getConnection();
        String sql="select * from exam where grade='NULL'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String teacher=rs.getString("teacher");
                String exam=rs.getString("examname");
                String classroom=rs.getString("classroom");
                String time=rs.getString("time");
                String condition=rs.getString("condi");
                String grade=rs.getString("grade");

                Exam exam1=new Exam(teacher,exam,classroom,time,condition,grade);
                examList.add(exam1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return examList;
    }

    //管理员删除考试
    public boolean adminDeleteExam(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from exam where teacher=? and examname=? and classroom=? and time=?";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            ps.setString(2,examname);
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

    //管理员修改考试
    public boolean adminModifyExam(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="update exam set classroom=?,time=? where teacher=? and examname=?";
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

    //添加评分
    public boolean AddGrade(String teacher,String examname,String classroom,String time,String grade){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="update exam set grade=? where teacher=? and examname=? and classroom=? and time=?";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,grade);
            ps.setString(2,teacher);
            ps.setString(3,examname);
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

    //我的考试
    public List<Exam> MyExam(String teacher){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<Exam> examList=new ArrayList<Exam>();
        conn= DButils.getConnection();
        String sql="select * from exam where teacher=? and student='NULL'";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            rs=ps.executeQuery();
            while(rs.next()){
                String tea=rs.getString("teacher");
                String exam=rs.getString("examname");
                String classroom=rs.getString("classroom");
                String time=rs.getString("time");
                String condition=rs.getString("condi");
                String grade=rs.getString("grade");

                Exam exam1=new Exam(teacher,exam,classroom,time,condition,grade);
                examList.add(exam1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return examList;
    }

    //考试结束
    public boolean finishExam(String teacher,String examname,String classroom,String time){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="update exam set condi='考试结束' where teacher=? and examname=? and classroom=? and time=?";
        conn=DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,teacher);
            ps.setString(2,examname);
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
}
