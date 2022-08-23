<%--
  Created by IntelliJ IDEA.
  User: nxg
  Date: 2021/8/23
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>restful风格</title>
    <script src="/js/jquery-1.11.1.js"></script>
</head>
<body>
<form id="myForm" action="" method="post">
    球队ID:<input type="text" name="teamId" id="teamId" /><br/>
    球队名称:<input type="text" name="teamName" /><br/>
    球队位置:<input type="text" name="location" /><br/>
    <button type="button" id="btnGetAll">查询所有GET</button>
    <button type="button" id="btnGetOne">查询单个GET</button>
    <button type="button" id="btnPost">添加POST</button>
    <button type="button" id="btnPut">更新PUT</button>
    <button type="button" id="btnDel">删除DELETE</button>
</form>
<p id="showResult"></p>
</body>
<script>
    //页面加载完毕之后给按钮绑定事件
    $(function(){

        //给 删除DELETE 按钮绑定单击事件
        $("#btnDel").click(function () {
            $.ajax({
                type:"POST",
                url:"/team/"+$("#teamId").val(),
                data:"_method=DELETE",
                dataType:"json",
                success:function (msg) {
                    $("#showResult").html(msg);
                }
            });
        });

        //给 更新PUT 按钮绑定单击事件
        $("#btnPut").click(function () {
            $.ajax({
               type:"POST",
               url:"/team/"+$("#teamId").val(),
               data:$("#myForm").serialize()+"&_method=PUT",
                dataType:"json",
                success:function (msg) {
                    $("#showResult").html(msg);
                }
            });
        });

        //给 添加POST 按钮绑定单击事件
        $("#btnPost").click(function () {
            alert($("#myForm").serialize());
            //发起异步请求
            $.ajax({
                type: "POST",
                url: "/team", //RESTful风格的API定义
                data: $("#myForm").serialize(),//表单的所有数据以？&形式追加在URL后面   /team?teamId=1006&teamName=kuaichuan&location=las
                dataType:"json",
                success: function(msg){
                //alert( "Data Saved: " + msg );
                $("#showResult").html(msg);
            }
        });
        });

        //给 查询所有GET 按钮绑定单击事件
        $("#btnGetAll").click(function () {
            $.ajax({
                type:"GET",
                url:"/teams",//RESTful风格的API定义
                data:"",
                dataType:"json",
                success:function (list) {
                    var str = "";
                    for (var i=0;i<list.length;i++){
                        var obj = list[i];
                        str += obj.teamId+"-------"+obj.teamName+"-----"+obj.location+"<br/>";
                    }
                    $("#showResult").html(str);
                }
            });
        });

        //给 查询单个GET 按钮绑定单击事件
        $("#btnGetOne").click(function () {
            //发起异步请求
            $.ajax({
                type: "GET",
                url: "/team/"+$("#teamId").val(), //RESTful风格的API定义
                data: "",
                dataType:"json",
                success: function(obj){
                    alert( "Data Saved: " + obj );
                    if(obj==""){
                        $("#showResult").html("没有复合条件的数据！");
                    }else {
                        $("#showResult").html(obj.teamId + "----" + obj.teamName + "----" + obj.location);
                    }
                }
            });
        });

    });
</script>
</html>
