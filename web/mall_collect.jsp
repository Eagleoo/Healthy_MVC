<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/6/15
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的收藏</title>
    <link type="text/css" rel="stylesheet" href="reset.css">
    <link type="text/css" rel="stylesheet" href="main.css">
    <script src="jquery-3.3.1.js"></script>
</head>
<body>
<div class="mall_collect_title">
    <span>健康商品收藏夹</span>
    <a href="index.jsp"> 返回首页</a>
</div>
<div class="mall_collect_show">
</div>
<script>
    function datashow() {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectmalliscollect_Servlet",
            dataType: 'json',
            success : function(data)
            {
                var length=data.length;
                var html = "";
                for(var i=0;i<length;i++){    //遍历data数组
                    var ls = data[i];
                    html +="<div class='mall_show'><a href='mall_detail.jsp?mall_id="+ls.mall_id+"'><img src="+ls.mall_img+"></a>" +
                        "<a href='mall_detail.jsp?mall_id="+ls.mall_id+"'><h1>"+ls.mall_name+"</a>" +
                        "</h1><br><h2>"+"￥"+ls.mall_price+"</h2></div>";
                    $(".mall_collect_show").html(html);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    }
    window.onload=function checklogin() {
        $.ajax({
            type: "post",
            url: "http://localhost:8080/Checklogin_Servlet",
            dataType: 'json',
            success: function (data) {
                if (data[0].user == null) {
                    alert("你还没登录");
                    window.open("login.jsp", "_self");
                }
                else {
                    datashow()
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }
</script>
</body>
</html>
