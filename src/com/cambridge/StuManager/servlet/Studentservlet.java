package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Studentservlet extends HttpServlet {
    StudentService studentService=new StudentService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String param=request.getParameter("param");

        if("search".equals(param)){
            String contend=request.getParameter("search");
            String student=request.getParameter("student");
            request.setAttribute("contend",contend);
            request.setAttribute("student",student);
            request.getRequestDispatcher("SearchCourse.jsp").forward(request,response);
        }else if("cancel".equals(param)){
            String student=request.getParameter("student");
            boolean result=studentService.cancel(student);
            if(result){
                response.sendRedirect("index.jsp");
            }
        }
    }
}
