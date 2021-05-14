<%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/14
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminModifyExam</title>
</head>
<body>
<%
    String teacher=request.getParameter("teacher");
    String examname=request.getParameter("examname");
    String classroom=request.getParameter("classroom");
    String time=request.getParameter("time");
%>
<h1 align="center">学生管理系统</h1>
<h2 align="center">管理员修改考试</h2>
<hr/>
<form action="Examservlet?param=adminmodifyexam" method="post" align="center">
    监考教师：<input type="text" name="teacher" value="<%=teacher%>" readonly/><br/>
    考试科目：<input type="text" name="examname" value="<%=examname%>" readonly/><br/>
    教室：<input type="text" name="classroom" value="<%=classroom%>"/><br/>
    时间：<select name="time">
    <option>8：00</option>
    <option>10：00</option>
    <option>14：00</option>
    <option>16：00</option>
    <option>18：00</option>
</select><br/>
    <br/>
    <input type="submit" value="提交"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
