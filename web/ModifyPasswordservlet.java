package com.cambridge.StuManager.servlet;

import com.cambridge.StuManager.service.ModifyPasswordService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyPasswordservlet extends HttpServlet {
    ModifyPasswordService modifyPasswordService=new ModifyPasswordService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String param=request.getParameter("param");

        if("Student".equals(param)){
            String object=request.getParameter("name");
            String account=request.getParameter("account");
            String password=request.getParameter("password");

            boolean result=modifyPasswordService.modifystu(object,account,password);

            if(result){
                response.sendRedirect("index.jsp");
            }
        }else if("Teacher".equals(param)){
            String object=request.getParameter("name");
            String account=request.getParameter("account");
            String password=request.getParameter("password");

            boolean result=modifyPasswordService.modifytea(object,account,password);

            if(result){
                response.sendRedirect("index.jsp");
            }
        }


    }
}
