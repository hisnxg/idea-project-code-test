<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2022/7/28
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/testrest/zhangsan/18" method="get">
    <input type="submit" value="get">
</form>
<form action="/testrest/zhangsan/19" method="post">
    <input type="submit" value="post">
</form>
<form action="/testrest/zhangsan/21" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="put">
</form>
<form action="/testrest/zhangsan/24" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="delete">
</form>
</body>
</html>
