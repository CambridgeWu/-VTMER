package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;
import com.cambridge.StuManager.po.TeacherLogin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherLoginDao {

    //确认后将教师的账号密码插入mysql中
    public boolean inserintoTea(String name,String account,String password){
        Connection conn=null;
        PreparedStatement ps=null;
        boolean isOK=false;

        conn=DButils.getConnection();
        String sql="insert into teacherlogin (name,account,password) values(?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,account);
            ps.setString(3,password);
            int count=ps.executeUpdate();
            if(count==1){
                isOK=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(ps,conn);
        }
        return isOK;
    }

    //打印全体教师的注册信息
    public List<TeacherLogin> FindAllTeacherLogin(){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;

        List<TeacherLogin> Teacher=new ArrayList<TeacherLogin>();
        TeacherLogin teacherLogin=new TeacherLogin();
        conn= DButils.getConnection();
        String sql="select * from tlogin";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("name");
                String account=rs.getString("account");
                String password=rs.getString("password");

                teacherLogin.setName(name);
                teacherLogin.setAccount(account);
                teacherLogin.setPassword(password);
                Teacher.add(teacherLogin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return Teacher;
    }

    //删除教师注册信息
    public void deleteTlogin(String name,String account,String password){
        Connection conn=null;
        PreparedStatement ps=null;

        conn=DButils.getConnection();
        String sql="delete from tlogin where name=? and account=? and password=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,account);
            ps.setString(3,password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(ps,conn);
        }
    }
}
