<%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/4
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
    <script type="text/javascript">
      function registerForm() {
        window.location.href="registerForm.jsp";
      }
    </script>
  </head>
  <body>
  <h1 align="center">学生管理系统</h1>
  <h2 align="center">用户登录</h2>
  <hr/>
  <form action="Loginservlet" method="post" align="center">
    账号：<input type="text" name="account" tabindex="1"/><br/>
    密码：<input type="password" name="password" tabindex="1"/><br/>
    身份：<input type="radio" name="position" value="adminlogin"/>管理员
    <input type="radio" name="position" value="teacherlogin"/>教师
    <input type="radio" name="position" value="stulogin"/>学生
    <br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
    <input type="button" value="注册" onclick="registerForm();"/>
  </form>
  <h3 align="center">制作人：吴剑桥</h3>
  </body>
</html>
