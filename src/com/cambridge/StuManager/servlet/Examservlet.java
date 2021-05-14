package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.po.Exam;
import com.cambridge.StuManager.service.ExamService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Examservlet extends HttpServlet {
    ExamService examService=new ExamService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String param=request.getParameter("param");

        if("add".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,examname,classroom,time);

            boolean result=examService.TAddExam(course);
            if(result){
                request.setAttribute("name",teacher);
                request.getRequestDispatcher("Teacher.jsp").forward(request,response);
            }
        }else if("confirmadd".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,examname,classroom,time);

            boolean result=examService.ConfirmAdd(course);
            if(result){
                examService.DeleteExam(course);
                request.setAttribute("name",teacher);
                request.getRequestDispatcher("EManager.jsp").forward(request,response);
            }
        }else if("delete".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,examname,classroom,time);

            examService.DeleteExam(course);
            request.setAttribute("name",teacher);
            request.getRequestDispatcher("EManager.jsp").forward(request,response);
        }else if("modify".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,examname,classroom,time);

            boolean result=examService.ModifyExam(course);
            if(result){
                request.setAttribute("name",teacher);
                request.getRequestDispatcher("EManager.jsp").forward(request,response);
            }
        }else if("deleteexam".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("examname");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,examname,classroom,time);

            boolean result=examService.adminDeleteExam(course);
            if(result){
                response.sendRedirect("GManager.jsp");
            }
        }
        else if("adminmodifyexam".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("examname");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,examname,classroom,time);

            boolean result=examService.adminModifyExam(course);
            if(result){
                response.sendRedirect("GManager.jsp");
            }
        }else if("addgrade".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("examname");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");
            String condition=request.getParameter("condition");
            String grade=request.getParameter("grade");

            Exam exam=new Exam(teacher,examname,classroom,time,condition,grade);

            boolean result=examService.AddGrade(exam);
            if(result){
                response.sendRedirect("MyExam.jsp");
            }
        }else if("finish".equals(param)){
            String teacher=request.getParameter("teacher");
            String examname=request.getParameter("examname");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Exam exam=new Exam(teacher,examname,classroom,time);

            boolean result=examService.finishExam(exam);
            if(result){
                request.setAttribute("teacher",teacher);
                request.getRequestDispatcher("ShowExam.jsp").forward(request,response);
            }
        }
    }
}
