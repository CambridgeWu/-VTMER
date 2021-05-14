package com.cambridge.StuManager.service;

import com.cambridge.StuManager.Dao.ModifyPasswordDao;

public class ModifyPasswordService {
    ModifyPasswordDao modifyPasswordDao=new ModifyPasswordDao();

    public boolean modify(String student,String account,String password){
        return modifyPasswordDao.modify(student,account,password);
    }

}
