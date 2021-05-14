package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.po.LoginInfo;
import com.cambridge.StuManager.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Repeatable;

public class Registerservlet extends HttpServlet {
    private RegisterService registerService=new RegisterService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name=request.getParameter("name");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String object=request.getParameter("position");
        LoginInfo loginInfo=new LoginInfo(name,object,account,password);

        boolean isOK=registerService.insertInfo(loginInfo);
        if(isOK){
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
    }
}
