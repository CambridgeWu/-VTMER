<%@ page import="com.cambridge.StuManager.service.CourseService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cambridge.StuManager.po.Course" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/13
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EManager</title>
</head>
<script type="text/javascript">
    function addCourse(teacher,coursename,classroom,time) {
        var result = window.confirm("确认添加吗？");
        if (result) {
            window.location.href = "Examservlet?param=confirmadd&teacher=" + teacher + "&coursename=" + coursename + "&classroom=" + classroom + "&time=" + time;
        }
    }
    function deleteCourse(teacher,coursename,classroom,time) {
        var result = window.confirm("确认删除吗？");
        if (result) {
            window.location.href = "Examservlet?param=delete&teacher=" + teacher + "&coursename=" + coursename + "&classroom=" + classroom + "&time=" + time;
        }
    }
    function modify(teacher,coursename,classroom,time) {
        window.location.href="ModifyExam.jsp?teacher=" + teacher + "&coursename=" + coursename + "&classroom=" + classroom + "&time=" + time;
    }
</script>
<body>
<%
    CourseService courseService=new CourseService();
    List<Course> courseList=courseService.FindAllExam();
%>
<h1 align="center">VTMER课程系统</h1>
<h2 align="center">考试管理</h2>
<hr />
<table width="800" align="center">
    <tr>
        <th align="right"><input type="button" value="返回" onclick="window.location.href='Admin.jsp';"></th>
    </tr>
</table>
<table width="1000" border="1" align="center">
    <tr>
        <th>监考教师</th>
        <th>考试科目</th>
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
            <a href="#" onclick="addCourse('<%=course.getTeacher()%>','<%=course.getCoursename()%>','<%=course.getClassroom()%>','<%=course.getTime()%>');">添加</a>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="#" onclick="deleteCourse('<%=course.getTeacher()%>','<%=course.getCoursename()%>','<%=course.getClassroom()%>','<%=course.getTime()%>');">删除</a>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="#" onclick="modify('<%=course.getTeacher()%>','<%=course.getCoursename()%>','<%=course.getClassroom()%>','<%=course.getTime()%>');">修改</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
