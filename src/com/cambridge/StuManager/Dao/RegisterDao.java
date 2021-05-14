package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
    public boolean insertInfo(String name,String object,String account,String password) {
        boolean isOk = false;
        Connection conn = null;
        PreparedStatement ps = null;

        conn= DButils.getConnection();

       if(object.equals("stulogin")){
            String sql="insert into stulogin (name,account,password) values(?,?,?)";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,account);
                ps.setString(3,password);
                int count=ps.executeUpdate();
                if(count==1){
                    isOk=true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DButils.close(ps,conn);
            }
        }else if(object.equals("tlogin")){
            String sql="insert into tlogin (name,account,password) values(?,?,?)";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,account);
                ps.setString(3,password);
                int count=ps.executeUpdate();
                if(count==1){
                    isOk=true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DButils.close(ps,conn);
            }
        }
        return isOk;
    }
}
