<%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/14
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TMPassword</title>
</head>
<body>
<%
    String name=request.getParameter("teacher");
    String account=request.getParameter("account");
    String password=request.getParameter("password");
%>
<h2 align="center">修改密码</h2>
<hr />
<form action="ModifyPasswordservlet?param=Teacher" method="post" >
    <table align="center" width="400">
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" value="<%=name%>" readonly/> </td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="account" value="<%=account%>" readonly/> </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"/> </td>
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
