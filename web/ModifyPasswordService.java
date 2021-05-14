package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.ModifyPasswordDao;

public class ModifyPasswordService {
    ModifyPasswordDao modifyPasswordDao=new ModifyPasswordDao();

    public boolean modifystu(String student,String account,String password){
        return modifyPasswordDao.modifystu(student,account,password);
    }

    public boolean modifytea(String teacher,String account,String password){
        return modifyPasswordDao.modifytea(teacher,account,password);
    }
}
