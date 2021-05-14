package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.LoginDao;
import com.cambridge.StuManager.Dao.RegisterDao;
import com.cambridge.StuManager.po.LoginInfo;

public class RegisterService {
    private RegisterDao registerDao=new RegisterDao();

    public boolean insertInfo(LoginInfo loginInfo){
        return registerDao.insertInfo(loginInfo.getName(),loginInfo.getIdentity(),loginInfo.getAccount(),loginInfo.getPassword());
    }
}
