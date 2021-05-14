<%@ page import="com.cambridge.StuManager.servlet.Examservlet" %>
<%@ page import="com.cambridge.StuManager.service.ExamService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cambridge.StuManager.po.Exam" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/14
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowExam</title>
</head>
<script type="text/javascript">
    function finishexam(teacher,examname,classroom,time) {
        var result=window.confirm("确定结束吗？");
        if(result){
            window.location.href="Examservlet?param=finish&teacher="+teacher+"&examname="+examname+"&classroom="+classroom+"&time="+time;
        }
    }
</script>
<body>
<%
    String teacher="";
    if((String)request.getAttribute("teacher")==null){
        teacher=request.getParameter("teacher");
    }else{
        teacher=(String)request.getAttribute("teacher");
    }
    ExamService examService=new ExamService();
    List<Exam> examList=examService.MyExam(teacher);
%>
<h1 align="center">VTMER课程系统</h1>
<h2 align="center">我的考试</h2>
<table width="800" align="center">
    <tr>
        <th align="right"><input type="button" value="返回" onclick="window.location.href='Teacher.jsp?teacher=<%=teacher%>';"></th>
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
        for (Exam exam : examList) {
    %>
    <tr>
        <td><%=exam.getTeacher()%></td>
        <td><%=exam.getExamname()%></td>
        <td><%=exam.getClassroom()%></td>
        <td><%=exam.getTime()%></td>
        <td><%=exam.getCondition()%></td>
        <td><%=exam.getGrade()%></td>
        <td align="center">
            <a href="#" onclick="finishexam('<%=exam.getTeacher()%>','<%=exam.getExamname()%>','<%=exam.getClassroom()%>','<%=exam.getTime()%>');">结束考试</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
