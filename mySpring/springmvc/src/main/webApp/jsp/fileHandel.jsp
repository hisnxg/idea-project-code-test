<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2021/8/23
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    请选择文件:<input type="file" name="myFile"><br/>
    <button type="submit">上传</button>
</form> <br/>
<form action="/file/download" method="post" enctype="multipart/form-data">
    文件下载
    <button type="submit">文件下载3de393cdc0624569a1dcb938b10a0a74.jpg</button>
</form>
</body>
</html>
