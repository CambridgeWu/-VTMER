<%@ page import="com.cambridge.StuManager.service.CourseService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cambridge.StuManager.po.Exam" %>
<%@ page import="com.cambridge.StuManager.service.ExamService" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/13
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyExam</title>
</head>
<script type="text/javascript">
    function addgrade(teacher,examname,classroom,time,condition) {
        if("正在考试"==condition){
            window.confirm("正在考试中！");
        }else if("考试结束"==condition){
            window.location.href="AddGrade.jsp?teacher="+teacher+"&examname="+examname+"&classroom="+classroom+"&time="+time+"&condition="+condition;
        }
    }
</script>
<body>
<%
    String student=request.getParameter("student");
    CourseService courseService=new CourseService();
    List<String> examname=courseService.FindAllCourseByStudent(student);

    ExamService examService=new ExamService();
    List<Exam> AllexamList=examService.FindAllExam();
%>
<h1 align="center">VTMER课程系统</h1>
<h2 align="center">MyExam</h2>
<table width="800" align="center">
    <tr>
        <th align="right"><input type="button" value="返回" onclick="window.location.href='Student.jsp?student=<%=student%>';"></th>
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
        for (String exam : examname) {
            for(Exam allexamlist:AllexamList){
                if(allexamlist.getExamname().equals(exam)){
                    Exam Myexam=examService.FindExamBycoursename(exam);
    %>
                    <tr>
                        <td><%=Myexam.getTeacher()%></td>
                        <td><%=Myexam.getExamname()%></td>
                        <td><%=Myexam.getClassroom()%></td>
                        <td><%=Myexam.getTime()%></td>
                        <td><%=Myexam.getCondition()%></td>
                        <td><%=Myexam.getGrade()%></td>
                        <td align="center">
                            <a href="#" onclick="addgrade('<%=Myexam.getTeacher()%>','<%=Myexam.getExamname()%>','<%=Myexam.getClassroom()%>',
                                    '<%=Myexam.getTime()%>','<%=Myexam.getCondition()%>','<%=Myexam.getGrade()%>');">评分</a>
                        </td>
                    </tr>
    <%
                }
            }
        }
    %>

</table>
</body>
</html>
