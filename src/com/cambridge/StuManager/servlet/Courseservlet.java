package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.po.Course;
import com.cambridge.StuManager.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Courseservlet extends HttpServlet {
    //处理课程相关问题
    CourseService courseService=new CourseService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String param=request.getParameter("param");


        //管理员确认添加教师设置的课程
        if("add".equals(param)){
            String teacher=request.getParameter("teacher");
            String coursename=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,coursename,classroom,time);

            boolean result=courseService.addCourse(course);
            if(result){
                courseService.deleteCourse(course);
                response.sendRedirect("CManager.jsp");
            }
        }else if("delete".equals(param)){
            String teacher=request.getParameter("teacher");
            String coursename=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,coursename,classroom,time);

            boolean result=courseService.deleteCourse(course);
            if(result){
                response.sendRedirect("CManager.jsp");
            }
        }else if("studentadd".equals(param)){
            String teacher=request.getParameter("teacher");
            String coursename=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,coursename,classroom,time);

            String student=request.getParameter("student");
            Course course1=new Course(student,teacher,coursename,classroom,time);
            boolean result=courseService.stuCourseAdd(course1);
            if(result){
                request.setAttribute("name",student);
                request.getRequestDispatcher("Student.jsp").forward(request,response);
            }
        }else if("modify".equals(param)){
            String teacher=request.getParameter("teacher");
            String coursename=request.getParameter("coursename");
            String classroom=request.getParameter("classroom");
            String time=request.getParameter("time");

            Course course=new Course(teacher,coursename,classroom,time);

            boolean result=courseService.ModifyCourse(course);
            if(result){
                response.sendRedirect("CManager.jsp");
            }
        }

    }
}
