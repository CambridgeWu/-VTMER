<%@ page import="javax.naming.Name" %>
<%@ page import="com.cambridge.StuManager.po.Course" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/11
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher</title>
</head>
<script type="text/javascript">
    function addcourse(teacher) {
        window.location.href="addcourse.jsp?param=add&teacher="+teacher;
    }
    function exit() {
        var result=window.confirm("确认退出吗？");
        if(result){
            window.location.href="index.jsp";
        }
    }
    function cancel(teacher,account,password) {
        var result=window.confirm("确认注销吗？");
        if(result){
            window.location.href="Teacherservlet?param=cancel&teacher="+teacher+"&account="+account+"&password="+password;
        }
    }
    function addExam(teacher) {
        window.location.href="Exam.jsp?teacher="+teacher;
    }
    function Loginout() {
        var result=window.confirm("是否要退出？")
        if(result){
            window.location.href="index.jsp";
        }
    }
    function showexam(teacher) {
        window.location.href="ShowExam.jsp?teacher="+teacher;
    }
</script>
<body>
        <%
            String teacher="";
            if((String)request.getAttribute("name")==null){
                teacher=request.getParameter("teacher");
            }else{
                teacher=(String)request.getAttribute("name");
            }
            String account=(String)request.getAttribute("account");
            String password=(String)request.getAttribute("password");
        %>
        <h1 align="center">VTMER课程系统</h1>
        <h2 align="center">教师:<%=teacher%></h2>
        <hr />
        <table width="800" align="center">
            <tr>
                <th align="center"><input type="button" value="退出" onclick="Loginout();"></th>
            </tr>
        </table>
        <form>
            <table align="center">
                <tr>
                    <td><input type="button" value="添加课程" style="width:200px;height:200px;color: magenta" onclick="addcourse('<%=teacher%>');"/></td>
                    <td><input type="button" value="我的考试" style="width:200px;height:200px;color: magenta" onclick="showexam('<%=teacher%>');"/></td>
                    <td><input type="button" value="添加考试" style="width:200px;height:200px;color: magenta" onclick="addExam('<%=teacher%>');"/></td>
                </tr>
                <tr>
                    <td><input type="button" value="登出" style="width:200px;height:200px;color: magenta" onclick="exit();"></td>
                    <td><input type="button" value="注销账号" style="width:200px;height:200px;color: magenta" onclick="cancel('<%=teacher%>','<%=account%>','<%=password%>');"></td>
                    <td><input type="button" value="修改密码" style="width:200px;height:200px;color: magenta"></td>
                </tr>
            </table>
        </form>
</body>
</html>
