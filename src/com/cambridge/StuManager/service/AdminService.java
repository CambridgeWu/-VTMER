package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.AdminDao;
import com.cambridge.StuManager.po.TeacherLogin;

public class AdminService {
    AdminDao adminDao=new AdminDao();

    //确认删除教师账号
    public boolean confirmcancel(TeacherLogin teacherLogin){
        return adminDao.confirmcancel(teacherLogin.getName(),teacherLogin.getAccount(),teacherLogin.getPassword());
    }

    //删除要注销的教师账号
    public boolean DeleteCancel(TeacherLogin teacherLogin){
        return adminDao.DeleteCancel(teacherLogin.getName(),teacherLogin.getAccount(),teacherLogin.getPassword());
    }
}
