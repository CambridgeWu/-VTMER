<%--
  Created by IntelliJ IDEA.
  User: 吴泽熙
  Date: 2021/5/7
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
    <script type="text/javascript">
        function TManager() {
            window.location.href="TManager.jsp";
        }
        function CManager() {
            window.location.href="CManager.jsp";
        }
        function EManager() {
            window.location.href="EManager.jsp";
        }
        function GManager() {
            window.location.href="GManager.jsp";
        }
        function Loginout() {
            var result=window.confirm("是否要退出？")
            if(result){
                window.location.href="index.jsp";
            }
        }
    </script>
</head>
<body>
    <h1 align="center">VTMER课程系统</h1>
    <h2 align="center">管理员</h2>
    <hr/>
    <table width="800" align="center">
        <tr>
            <th align="center"><input type="button" value="退出" onclick="Loginout();"></th>
        </tr>
    </table>
    <table align="center" width="100" border="4">
        <tr><!-- 表头大小要改变-->
            <td width="200" height="300"><input type="button" value="教师账号管理" style="width:200px;height:200px;color: magenta" onclick="TManager();"/></td>
            <td width="200" height="300"><input type="button" value="课程管理" style="width:200px;height:200px;color: magenta" onclick="CManager();"/></td>
        </tr>
        <tr>
            <td width="200" height="300"><input type="button" value="考试管理" style="width:200px;height:200px;color: magenta" onclick="EManager();"/></td>
            <td width="200" height="300"><input type="button" value="所有考试" style="width:200px;height:200px;color: magenta" onclick="GManager();"/></td>
        </tr>
    </table>
</body>
</html>
