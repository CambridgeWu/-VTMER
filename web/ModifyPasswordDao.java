package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModifyPasswordDao {
    public boolean modifystu(String student,String account,String password){
        Connection conn=null;
        PreparedStatement ps=null;
        boolean result=false;

        String sql="update stulogin set account=?,password=? where name=?";
        conn= DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
            ps.setString(3,student);
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

    public boolean modifytea(String teacher,String account,String password){
        Connection conn=null;
        PreparedStatement ps=null;
        boolean result=false;

        String sql="update teacherlogin set account=?,password=? where name=?";
        conn= DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
            ps.setString(3,teacher);
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
