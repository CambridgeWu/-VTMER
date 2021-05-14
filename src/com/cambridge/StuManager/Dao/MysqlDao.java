package com.cambridge.StuManager.Dao;

import com.cambridge.StuManager.Utils.DButils;
import com.mysql.cj.conf.url.FailoverDnsSrvConnectionUrl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDao {
    //登录：检测数据库中是否存在相同数据
    public boolean isLegal(String sqlname,String account,String password){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        boolean islegal=true;

        String sql="select * from ? where account=? and password=?";
        conn= DButils.getConnection();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,sqlname);
            ps.setString(2,account);
            ps.setString(3,password);
            rs=ps.executeQuery();
            while(rs.next()){
                islegal=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.close(rs,ps,conn);
        }
        return islegal;
    }
}
