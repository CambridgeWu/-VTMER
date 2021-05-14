package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.TeacherLoginDao;
import com.cambridge.StuManager.po.TeacherLogin;

import java.util.List;

public class TeacherLoginService {
    TeacherLoginDao teacherLoginDao=new TeacherLoginDao();

    public List<TeacherLogin> FindAllTeacherLogin(){
        return teacherLoginDao.FindAllTeacherLogin();
    }

    public boolean insertIntoTea(TeacherLogin teacherLogin){
        return teacherLoginDao.inserintoTea(teacherLogin.getName(),teacherLogin.getAccount(),teacherLogin.getPassword());
    }

    public void deleteTlogin(TeacherLogin teacherLogin){
        teacherLoginDao.deleteTlogin(teacherLogin.getName(),teacherLogin.getAccount(),teacherLogin.getPassword());
    }
}
