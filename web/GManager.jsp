<%@ page import="com.cambridge.StuManager.service.ExamService" %>
<%@ page import="com.cambridge.StuManager.po.Exam" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/14
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GManager</title>
</head>
<script type="text/javascript">
    function deleteexam(teacher,examname,classroom,time) {
        var result=window.confirm("确认删除吗？");
        if(result){
            window.location.href="Examservlet?param=deleteexam&teacher="+teacher+"&examname="+examname+"&classroom="+classroom+"&time="+time;
        }
    }
    function modifyexam(teacher,examname,classroom,time) {
        var result=window.confirm("确认修改吗？");
        if(result){
            window.location.href="AdminModifyExam.jsp?teacher="+teacher+"&examname="+examname+"&classroom="+classroom+"&time="+time;
        }
    }
</script>
<body>
<%
    //展示所有考试
    ExamService examService=new ExamService();
    List<Exam> AllexamList=examService.FindAllExam();
%>
<h1 align="center">VTMER课程系统</h1>
<h2 align="center">所有考试</h2>
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
        <th>状态</th>
        <th>分数</th>
        <th>操作</th>
    </tr>`
    <%
        for (Exam exam: AllexamList) {
    %>
    <tr>
        <td><%=exam.getTeacher()%></td>
        <td><%=exam.getExamname()%></td>
        <td><%=exam.getClassroom()%></td>
        <td><%=exam.getTime()%></td>
        <td><%=exam.getCondition()%></td>
        <td><%=exam.getGrade()%></td>
        <td align="center">
            <a href="#" onclick="deleteexam('<%=exam.getTeacher()%>','<%=exam.getExamname()%>','<%=exam.getClassroom()%>','<%=exam.getTime()%>');">删除</a>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="#" onclick="modifyexam('<%=exam.getTeacher()%>','<%=exam.getExamname()%>','<%=exam.getClassroom()%>','<%=exam.getTime()%>');">修改</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
