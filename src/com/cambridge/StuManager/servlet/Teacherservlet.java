package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.po.TeacherLogin;
import com.cambridge.StuManager.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Teacherservlet extends HttpServlet {
    TeacherService teacherService=new TeacherService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //添加课程需要管理员审核
        request.setCharacterEncoding("UTF-8");
        String param=request.getParameter("param");

        if("add".equals(param)){
            String teacher=request.getParameter("teacher");
            String coursename=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,coursename,classroom,time);

            boolean result=teacherService.addCourse(course);
            if(result){
                request.setAttribute("name",teacher);
                request.getRequestDispatcher("Teacher.jsp").forward(request,response);
            }
        }else if("cancel".equals(param)){//也需要向管理员审核
            String name=request.getParameter("teacher");
            String account=request.getParameter("account");
            String password=request.getParameter("password");
            TeacherLogin teacherLogin=new TeacherLogin(name,account,password);

            boolean result=teacherService.TeacherLoginCancel(teacherLogin);
            if(result){
                response.sendRedirect("index.jsp");
            }
        }



    }
}
