<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2022/7/28
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主页</h1>
<a href="/test3?username=xiaoming&age=18">点击我发送test请求，跳转到success.jsp页面</a>
<br>
<form action="/test2" method="post">
   uname: <input type="text" name="uname">
   birthday:<input type="text" name="birthday"><br>
    <input type="submit" value="提交方式---POST">
</form>
</body>
</html>
