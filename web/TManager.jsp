<%@ page import="com.cambridge.StuManager.service.TeacherLoginService" %>
<%@ page import="com.cambridge.StuManager.po.TeacherLogin" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cambridge.StuManager.service.TeacherService" %><%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/7
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TManager</title>
</head>
<script type="text/javascript">
    function Confirmregister(name,account,password) {
        var result=window.confirm("确认注册吗？");
        if(result){
            window.location.href="Adminservlet?param=confirmregister&name="+name+"&account="+account+"&password="+password;
        }
    }

    function Deleteservlet(name,account,password) {
        var result=window.confirm("确认删除吗？");
        if(result){
            window.location.href="Adminservlet?param=delete&name="+name+"&account="+account+"&password="+password;
        }
    }

    function confirmcancel(name,account,password) {//确认
        var result=window.confirm("确认注销吗？");
        if(result){
            window.location.href="Adminservlet?param=confirmcancel&name="+name+"&account="+account+"&password="+password;
        }
    }

    function Deleteservlet(name,account,password) {//取消注销
        var result=window.confirm("确认删除吗？");
        if(result){
            window.location.href="Adminservlet?param=canceldelete&name="+name+"&account="+account+"&password="+password;
        }
    }
</script>
<body><!-- 教师账号管理-->
        <%
            //收集所有教师的注册数据
            TeacherService teacherService=new TeacherService();
            List<TeacherLogin> cancel=teacherService.FindAllTeacherCancel();
            //收集所有教师的注册数据
            TeacherLoginService teacherLoginService=new TeacherLoginService();
            List<TeacherLogin> teacherList=teacherLoginService.FindAllTeacherLogin();
        %>
        <h2 align="center">教师账号管理</h2>
        <hr/>
        <table width="800" align="center">
            <tr>
                <th align="right"><input type="button" value="返回" onclick="window.location.href='Admin.jsp';"></th>
            </tr>
        </table>
        <table width="800" border="1" align="center">
            <tr>
                <th>姓名</th>
                <th>账号</th>
                <th>密码</th>
                <th>操作</th>
            </tr>
            <%
                for (TeacherLogin tea : teacherList) {
            %>
                    <tr>
                        <td><%=tea.getName()%></td>
                        <td><%=tea.getAccount()%></td>
                        <td><%=tea.getPassword()%></td>
                        <td align="center">
                            <a href="#" onclick="Confirmregister('<%=tea.getName()%>','<%=tea.getAccount()%>','<%=tea.getPassword()%>');">确认注册</a>
                            &nbsp;&nbsp;|&nbsp;&nbsp;
                            <a href="#" onclick="Deleteservlet('<%=tea.getName()%>','<%=tea.getAccount()%>','<%=tea.getPassword()%>');">删除</a>
                        </td>
                    </tr>
            <%
                }
            %>
            <%
                for (TeacherLogin tea : cancel) {
            %>
            <tr>
                <td><%=tea.getName()%></td>
                <td><%=tea.getAccount()%></td>
                <td><%=tea.getPassword()%></td>
                <td align="center">
                    <a href="#" onclick="confirmcancel('<%=tea.getName()%>','<%=tea.getAccount()%>','<%=tea.getPassword()%>');">确认注销</a>
                    &nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="#" onclick="Deleteservlet('<%=tea.getName()%>','<%=tea.getAccount()%>','<%=tea.getPassword()%>');">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
</body>
</html>
