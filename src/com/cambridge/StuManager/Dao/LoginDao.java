package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    //判断指定账号密码是否存在
    public boolean isExists(String object,String account,String password) {
        boolean isExits = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn=DButils.getConnection();

        if(object.equals("adminlogin")){
            String sql="select * from adminlogin where account=? and password=?";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,account);
                ps.setString(2,password);
                rs=ps.executeQuery();
                if(rs.next()){
                    isExits=true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DButils.close(rs,ps,conn);
            }
        }else if(object.equals("stulogin")){
            String sql="select * from stulogin where account=? and password=?";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,account);
                ps.setString(2,password);
                rs=ps.executeQuery();
                if(rs.next()){
                    isExits=true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DButils.close(rs,ps,conn);
            }
        }else if(object.equals("teacherlogin")){
            String sql="select * from teacherlogin where account=? and password=?";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,account);
                ps.setString(2,password);
                rs=ps.executeQuery();
                if(rs.next()){
                    isExits=true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DButils.close(rs,ps,conn);
            }
        }
        return isExits;
    }

    //返回对象的姓名
    public String getobjectName(String object,String account,String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name="";

        conn=DButils.getConnection();

        if(object.equals("stulogin")){
            String sql="select * from stulogin where account=? and password=?";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,account);
                ps.setString(2,password);
                rs=ps.executeQuery();
                if(rs.next()){
                    name=rs.getString("name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DButils.close(rs,ps,conn);
            }
        }else if(object.equals("teacherlogin")){
            String sql="select * from teacherlogin where account=? and password=?";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,account);
                ps.setString(2,password);
                rs=ps.executeQuery();
                if(rs.next()){
                    name=rs.getString("name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DButils.close(rs,ps,conn);
            }
        }
        return name;
    }
}
