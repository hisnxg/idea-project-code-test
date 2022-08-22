<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2022/7/29
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>文件上传成功！</h1>
<a href="/download?filename=${filename}">文件下载</a>
<img src="/uploadImg/${filename}"/>
</body>
</html>
