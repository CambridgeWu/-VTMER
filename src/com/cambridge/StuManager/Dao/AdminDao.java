package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDao {
    //确认删除教师账号
    public boolean confirmcancel(String name,String account,String password){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from teacherlogin where name=? and account=? and password=?";
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

    //删除要注销的教师账号
    public boolean DeleteCancel(String name,String account,String password){
        boolean result=false;
        Connection conn=null;
        PreparedStatement ps=null;

        String sql="delete from tcancel where name=? and account=? and password=?";
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
}
