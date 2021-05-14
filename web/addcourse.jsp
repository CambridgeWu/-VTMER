<%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/11
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addcourse</title>
</head>
<body>
<%
    String param=request.getParameter("param");
    String teacher=request.getParameter("teacher");
%>
<h1 align="center">学生管理系统</h1>
<h2 align="center">添加课程</h2>
<hr/>
<form action="Teacherservlet?param=<%=param%>" method="post" align="center">
    任课教师：<input type="text" name="teacher" value="<%=teacher%>" readonly/><br/>
    课程名：<input type="text" name="coursename"/><br/>
    教室：<input type="text" name="classroom"/><br/>
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
