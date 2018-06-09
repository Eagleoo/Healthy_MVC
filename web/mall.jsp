<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>健康商城</title>
    <link type="text/css" rel="stylesheet" href="reset.css">
    <link type="text/css" rel="stylesheet" href="main.css">
    <script src="jquery-3.3.1.js"></script>
</head>

<body>
<header>
    <div class="topBar">
        <div class="leftArea">
            <a href="#" class="collection">收藏</a>
        </div>
        <div class="rightArea">
            欢迎来到health    <a href="login.html" >[登 录]</a><a href="#">[注 册]</a>
        </div>
    </div>
</header>
<div class="navBox">
        <div class="logo">
            <img src="img/8.jpg" >
        </div>
        <div class="navdiv">
            <ul class="nav">
                <li><a href="index.jsp" class="active">首页</a></li>
                <li><a href="#">圈子</a></li>
                <li><a href="mall.jsp">商城</a></li>
                <li><a href="#">计步器</a></li>
                <li><a href="#">个人</a></li>
            </ul>
        </div>
</div>
<br>
<hr>
<div class="mall"></div>
<div class="mall_Fpage">
    <a href="#" onclick="yest();updatepage(pagestart,2)"><span>上一页</span></a>
    <a href="#" onclick="next();updatepage(pagestart,2)"><span>下一页</span></a>
</div>
<input type="hidden" id="allmallcount">

<script>
    var pagestart=0;
    function next() {
         if (pagestart+2<$('#allmallcount').val()){pagestart+=2;}
    }
    function yest() {
        if(pagestart-2>=0){pagestart-=2;}
    }
    function datashow() {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectmall_Servlet",
            data: {"mallstart":0,"mallcount":2},
            dataType: 'json',
            success : function(data)
            {
                alert(data.length)
                var length=data.length;
                var html = "";
                for(var i=0;i<length;i++){    //遍历data数组
                    var ls = data[i];
                    html +="<div class='mall_show'><a href='mall_detail.jsp?mall_id="+ls.mall_id+"'><img src="+ls.mall_img+"></a>" +
                        "<a href='mall_detail.jsp?mall_id="+ls.mall_id+"'><h1>"+ls.mall_describe+"</a>" +
                        "</h1><br><h2>"+"￥"+ls.mall_price+"</h2></div>";
                    $(".mall").html(html);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    }
    function updatepage(mallstart,mallcount) {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectmall_Servlet",
            data:{"mallstart":mallstart,"mallcount":mallcount},
            dataType: 'json',
            success : function(data)
            {
                var length=data.length;
                var html = "";
                for(var i=0;i<length;i++){    //遍历data数组
                    var ls = data[i];
                    html +="<div class='mall_show'><a href='mall_detail.jsp?mall_id="+ls.mall_id+"'><img src="+ls.mall_img+"></a>" +
                        "<a href='mall_detail.jsp?mall_id="+ls.mall_id+"'><h1>"+ls.mall_describe+"</a>" +
                        "</h1><br><h2>"+"￥"+ls.mall_price+"</h2></div>";
                    $(".mall").html(html);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    }
    function count() {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Rebackmallcount_Servlet",
            dataType: 'text',
            success : function(data)
            {
                $('#allmallcount').val(data*1)
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });

    }
    window.onload=function () {
        datashow();
        count();
    }
</script>

</body>
</html>