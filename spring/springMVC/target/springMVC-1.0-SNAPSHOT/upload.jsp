<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2022/7/29
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>上传</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
    上传文件：<input type="file" name="myfile">
    <input type="submit" value="上传">
</form>
</body>
</html>
