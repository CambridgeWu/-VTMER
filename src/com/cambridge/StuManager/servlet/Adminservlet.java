package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.po.TeacherLogin;
import com.cambridge.StuManager.service.AdminService;
import com.cambridge.StuManager.service.TeacherLoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Adminservlet extends HttpServlet {
    TeacherLoginService teacherLoginService=new TeacherLoginService();
    AdminService adminService=new AdminService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String param=request.getParameter("param");


        if("confirmregister".equals(param)){
            String name=request.getParameter("name");
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            TeacherLogin teacher=new TeacherLogin(name,account,password);

            boolean result=teacherLoginService.insertIntoTea(teacher);
            if(result){
                teacherLoginService.deleteTlogin(teacher);
                response.sendRedirect("TManager.jsp");
            }
        }else if("delete".equals(param)){
                String name=request.getParameter("name");
                String account=request.getParameter("account");
                String password=request.getParameter("password");
                TeacherLogin teacher=new TeacherLogin(name,account,password);

                teacherLoginService.deleteTlogin(teacher);
                response.sendRedirect("TManager.jsp");
        }else if("confirmcancel".equals(param)){
            String name=request.getParameter("name");
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            TeacherLogin teacherLogin=new TeacherLogin(name,account,password);

            boolean result=adminService.confirmcancel(teacherLogin);
            if(result){
                adminService.DeleteCancel(teacherLogin);
                response.sendRedirect("index.jsp");
            }
        }else if("canceldelete".equals(param)){
            String name=request.getParameter("name");
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            TeacherLogin teacher=new TeacherLogin(name,account,password);

            boolean result=adminService.DeleteCancel(teacher);
            if(result){
                response.sendRedirect("TCancel.jsp");
            }
        }


    }
}
