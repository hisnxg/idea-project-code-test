<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2021/8/22
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.11.1.js"></script>
</head>
<body>
<h1>result----------------</h1>
<h3>test02---request作用域获取:---${requestScope.team.teamName}--
    -${requestScope.team.teamId}---${requestScope.team.location}</h3>
<h3>test02---session作用域获取:---${sessionScope.team.teamName}--
    -${sessionScope.team.teamId}---${sessionScope.team.location}</h3>

<div>
    <button type="button" id="btn1">ajax请求自定义对象</button>
    <h3>ajax请求自定义对象的结果展示</h3>
    <p id="res"></p>
</div>

<div>
    <button type="button" id="btn2">ajax请求自定义对象</button>
    <h3>ajax请求自定义对象的结果展示</h3>
    <p id="res2"></p>
</div>
<div>
    <button type="button" id="btn3">ajax请求Map</button>
    <h3>ajax请求Map的结果展示</h3>
    <p id="res3"></p>
</div>

<script>
    $(function() {
        $("#btn1").click(function () {
            $.ajax({
                type: "POST",
                url: "/result/test03-3",
                data: "",
                success: function (msg) {
                    alert("Data Saved: " + msg);
                    var name = msg.teamName;
                    var id = msg.teamId;
                    var loc = msg.location;
                    $("#res").html("name:" + name + ",id:" + id + ",location:" + loc);
                }
            });
        });

            $("#btn2").click(function () {
                $.ajax({
                    type: "POST",
                    url: "/result/test03-4",
                    data: "",
                    success: function(list){
                        alert( "Data Saved: " + list );
                        var str="";
                        for(var i=0;i<list.length;i++){
                            var obj=list[i];
                            str+="name:"+obj.teamName+",id:"+obj.teamId+",location:"+obj.location+"<br/>";
                        }
                        $("#res2").html(str);
                    }
                });
            });

        $("#btn3").click(function () {
            $.ajax({
                type: "POST",
                url: "/result/test03-5",
                data: "",
                success: function(map){
                    alert( "Data Saved: " + map );
                    var str="";
                    $.each(map,function (i,obj) {
                        str+="name:"+obj.teamName+",id:"+obj.teamId+",location:"+obj.location+"<br/>";
                    });
                    $("#res3").html(str);
                }
            });
        });
    });
</script>
</body>
</html>
