<%@ page import="com.cambridge.StuManager.service.StudentService" %>
<%@ page import="com.cambridge.StuManager.po.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/12
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>searchCourse</title>
</head>
<script type="text/javascript">
    function addCourse(student,teacher,coursename,classroom,time) {
        var result=window.confirm("确认添加吗？");
        if(result){
            window.location.href="Courseservlet?param=studentadd&student="+student+"&teacher="+teacher+"&coursename="+coursename+"&classroom="+classroom+"&time="+time;
        }
    }
    function search(student) {
        window.location.href="Studentservlet?param=search&student="+student;
    }
</script>
<body>
<%
    String student=request.getParameter("student");
    String contend=request.getParameter("contend");

    StudentService studentService=new StudentService();
    List<Course> courseList=studentService.FindCourse(contend);
%>
<h1 align="center">VTMER课程系统</h1>
<h2 align="center">课程查询</h2>
<hr />
    <table align="center">
        <tr>
            <td>
                <input type="button" value="查询" onclick="search();">
                <input type="text" name="search">
                <input type="button" value="返回" onclick="window.location.href='Student.jsp';"/>
            </td>
        </tr>
    </table>
<table width="1000" border="1" align="center">
    <tr>
        <th>教师</th>
        <th>课程</th>
        <th>教室</th>
        <th>时间</th>
        <th>操作</th>
    </tr>
    <!-- 展示所有课程 -->
    <%
        for (Course course : courseList) {
    %>
    <tr>
        <td><%=course.getTeacher()%></td>
        <td><%=course.getCoursename()%></td>
        <td><%=course.getClassroom()%></td>
        <td><%=course.getTime()%></td>
        <td align="center">
            <a href="#" onclick="addCourse('<%=student%>','<%=course.getTeacher()%>','<%=course.getCoursename()%>','<%=course.getClassroom()%>','<%=course.getTime()%>');">添加</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
