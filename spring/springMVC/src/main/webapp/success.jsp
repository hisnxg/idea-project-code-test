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
    <link href="css/index.css" type="text/css"/>
</head>
<body>
<h1>success页面.jsp</h1>
<h1>编码格式支持中文：uname:${uname}</h1>
<h1>HttpSession:${sessionName}     <a href="/out">退出</a></h1>
<h1>通过注解存到session中sessionAttribute:${sessionScope.sessionAttribute}<a href="out3">退出</a></h1>
<h2>birthday：${birthday}</h2>
<h2>modelmapkey：${modelmapkey}</h2>
<h2>modelKey：${modelKey}</h2>
<h2>mvKey：${mvKey}</h2>
<img src="/img/emo.jpg" width="750px" height="350px" />

</body>
</html>
