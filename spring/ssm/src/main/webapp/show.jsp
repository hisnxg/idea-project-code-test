<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2022/8/8
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>book</h1>
<c:forEach items="${bookList}" var="book">
    ${book.bookId}---------${book.bookName}<br>
</c:forEach>
</body>
</html>
