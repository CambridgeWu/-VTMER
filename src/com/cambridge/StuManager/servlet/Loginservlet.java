package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.po.LoginInfo;
import com.cambridge.StuManager.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Position;
import java.io.IOException;

public class Loginservlet extends HttpServlet {
    private LoginService loginService=new LoginService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String object=request.getParameter("position");         //获取对象，更具对象判断登录
        LoginInfo loginInfo=new LoginInfo(object,account,password);
        //判断是否合法
        boolean legal=loginService.islegal(loginInfo);

        if(legal){
            if(object.equals("adminlogin")){
                response.sendRedirect("Admin.jsp");
            }else if(object.equals("teacherlogin")){
                //传递教师的姓名
                String name=loginService.getobjectName(loginInfo);
                request.setAttribute("name",name);
                request.setAttribute("account",account);
                request.setAttribute("password",password);
                request.getRequestDispatcher("Teacher.jsp").forward(request,response);
            }else if(object.equals("stulogin")){
                String student=loginService.getobjectName(loginInfo);
                request.setAttribute("student",student);
                request.setAttribute("account",account);
                request.setAttribute("password",password);
                request.getRequestDispatcher("Student.jsp").forward(request,response);
            }
        }else{
            response.sendRedirect("error.jsp");
        }
    }
}
