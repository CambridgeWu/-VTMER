package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.LoginDao;
import com.cambridge.StuManager.po.LoginInfo;

public class LoginService {
    private LoginDao loginDao=new LoginDao();

    //判断管理员是否合法
    public boolean islegal(LoginInfo loginInfo){
        return loginDao.isExists(loginInfo.getIdentity(),loginInfo.getAccount(),loginInfo.getPassword());
    }

    //返回对象的姓名
    public String getobjectName(LoginInfo loginInfo){
        return loginDao.getobjectName(loginInfo.getIdentity(),loginInfo.getAccount(),loginInfo.getPassword());
    }
}
