<%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/6
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerForm</title>
</head>
<body>
    <h2 align="center">注册</h2>
    <hr />
    <form action="Registerservlet" method="post" >
        <table align="center" width="400">
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name"/> </td>
            </tr>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="account"/> </td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"/> </td>
            </tr>
            <tr>
                <td>身份:</td>
                <td>
                    <input type="radio" name="position" value="tlogin"/>教师
                    <input type="radio" name="position" value="stulogin"/>学生
                </td>
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
