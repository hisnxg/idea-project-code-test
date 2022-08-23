<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2021/8/22
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>8、获取集合类型的参数</h3>
<form action="/param/test08" method="post">
    球队名称1：<input type="text" name="teamName"/><br/>
    球队名称2：<input type="text" name="teamName"/><br/>
    球队名称3：<input type="text" name="teamName"/><br/>
    <button type="submit">提交</button>
</form>
<form action="/param/test09" method="post">
    球队id1：<input type="text" name="teamList[0].teamId"/><br/>
    球队id2：<input type="text" name="teamList[1].teamId"/><br/>
    球队id3：<input type="text" name="teamList[2].teamId"/><br/>
    球队名称1：<input type="text" name="teamList[0].teamName"/><br/>
    球队名称2：<input type="text" name="teamList[1].teamName"/><br/>
    球队名称3：<input type="text" name="teamList[2].teamName"/><br/>
    <button type="submit">提交</button>
</form>

<h3>7、获取数组类型的参数</h3>
<form action="/param/test07" method="post">
    球队名称1：<input type="text" name="teamName"/><br/>
    球队名称2：<input type="text" name="teamName"/><br/>
    球队名称3：<input type="text" name="teamName"/><br/>
    <button type="submit">提交</button>
</form>
<h3>6、获取日期类型的参数</h3>
<form action="/param/test06" method="post">
    球队id：<input type="text" name="teamId"/><br/>
    球队名称：<input type="text" name="teamName"/><br/>
    球队位置：<input type="text" name="location"/><br/>
    创建日期：<input type="text" name="createTime"/><br/>
    <button type="submit">提交</button>
</form>
<h3>5、直接使用URL地址传参</h3>
<h3>4、使用HttpServletRequest 对象获取参数</h3>
<form action="/param/test04" method="post">
    球队id：<input type="text" name="teamId"/><br/>
    球队名称：<input type="text" name="teamName"/><br/>
    球队位置：<input type="text" name="location"/><br/>
    <button type="submit">提交</button>
</form>
<h3>3、请求参数和方法名称的参数不一致</h3>
<form action="/param/test03" method="post">
    球队id：<input type="text" name="teamId"/><br/>
    球队名称：<input type="text" name="teamName"/><br/>
    球队位置：<input type="text" name="location"/><br/>
    <button type="submit">提交</button>
</form>
<h3>2、使用对象接收多个参数</h3>
<form action="/param/test02" method="post">
    球队id：<input type="text" name="teamId"/><br/>
    球队名称：<input type="text" name="teamName"/><br/>
    球队位置：<input type="text" name="location"/><br/>
    <button type="submit">提交</button>
</form>
<h3>1、直接使用方法的参数逐个接收</h3>
<form action="/param/test01" method="post">
    球队id：<input type="text" name="teamId"/><br/>
    球队名称：<input type="text" name="teamName"/><br/>
    球队位置：<input type="text" name="teamLocation"/><br/>
    <button type="submit">提交</button>
</form>

</body>
</html>
