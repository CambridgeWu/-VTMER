<%@ page import="com.cambridge.StuManager.service.CourseService" %>
<%@ page import="com.cambridge.StuManager.po.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cambridge.StuManager.service.StudentService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.annotation.Documented" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/7
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<script language="JavaScript" type="text/javascript">
    function addCourse(student,teacher,coursename,classroom,time) {
        var result=window.confirm("确认添加吗？");
        if(result){
            window.location.href="Courseservlet?param=studentadd&student="+student+"&teacher="+teacher+"&coursename="+coursename+"&classroom="+classroom+"&time="+time;
        }
    }
    function exit() {
        var result=window.confirm("确认退出吗？");
        if(result){
            window.location.href="index.jsp";
        }
    }
    function cancel(student) {
        var result=window.confirm("确认注销吗？");
        if(result){
            window.location.href="Studentservlet?param=cancel&student="+student;
        }
    }
    function modifypassword(student,account,password) {
        window.location.href="modifypassword.jsp?student="+student+"&account="+account+"&password="+password;
    }
    function MyExam(student) {
        window.location.href="MyExam.jsp?student="+student;
    }
</script>
<body><!-- 课程管理-->
        <%
            String student="";
            if((String)request.getAttribute("student")==null){
                student=request.getParameter("student");
            }else{
                student=(String)request.getAttribute("student");
            }
            String account=(String)request.getAttribute("account");
            String password=(String)request.getAttribute("password");

            CourseService courseService=new CourseService();
            List<Course> courseList=courseService.FindAllCourse();
        %>
    <h1 align="center">VTMER课程系统</h1>
    <h2 align="center">学生:<%=student%></h2>
    <hr />
    <form name="thisform" action="" method="post">
        <table align="center">
            <tr>
                <td><input type="button" value="登出" onclick="exit();"></td>
                <td><input type="button" value="注销账号" onclick="cancel('<%=student%>');"></td>
                <td><input type="button" value="修改密码" onclick="modifypassword('<%=student%>','<%=account%>','<%=password%>');"></td>
                <td><input type="button" value="我的考试" onclick="MyExam('<%=student%>');"></td>
            </tr>
        </table>
    </form>
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
