<%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/14
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddGrade</title>
</head>
<body>
<%
    String teacher=request.getParameter("teacher");
    String examname=request.getParameter("examname");
    String classroom=request.getParameter("classroom");
    String time=request.getParameter("time");
    String condition=request.getParameter("condition");
%>
<h2 align="center">评分</h2>
<hr />
<form action="Examservlet?param=addgrade" method="post" >
    <table align="center" width="400">
        <tr>
            <td>监考教师:</td>
            <td><input type="text" name="teacher" value="<%=teacher%>" readonly/> </td>
        </tr>
        <tr>
            <td>考试科目:</td>
            <td><input type="text" name="examname" value="<%=examname%>" readonly/></td>
        </tr>
        <tr>
            <td>教室:</td>
            <td><input type="text" name="classroom" value="<%=classroom%>" readonly/></td>
        </tr>
        <tr>
            <td>时间:</td>
            <td><input type="text" name="time" value="<%=time%>" readonly/></td>
        </tr>
        <tr>
            <td>状态:</td>
            <td><input type="text" name="condition" value="<%=condition%>" readonly/></td>
        </tr>
        <tr>
            <td>评分:</td>
            <td><select name="grade">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select></td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="提交"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
