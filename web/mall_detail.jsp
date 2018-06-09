<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="main.css">
    <link type="text/css" rel="stylesheet" href="reset.css">
    <script src="public.js"></script>
    <script src="jquery-3.3.1.js"></script>
</head>
<body style="background-color: rgba(243,238,242,0.4)">
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
<div class="include_detail"><div class="detail"></div></div>
<div class="detailimg_show"></div>
<script>
    var mall_id=GetQueryString("mall_id");
    window.onload=function datashow() {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectmallbyid_Servlet",
            dataType: 'json',
            data : {"mall_id" :mall_id},
            success : function(data)
            {
                var length=data.length;
                var html = "";
                for(var i=0;i<length;i++){
                    var ls = data[i];
                    html +="<div class='malldetail_img'><img src="+ls.mall_img+"></div>"+
                        "<div class='malldetail_right'>" +
                        "<h1>"+ls.mall_describe+"</h1><span>￥</span><h2>"+ls.mall_price+"</h2>"+
                        "<input type='submit' value='立即下单' class='malldetail_torder' onclick='takeorder(mall_id)'>" +
                        "<input type='submit' value='收藏' class='malldetail_tcollect'></div>"
                    ;
                    $(".detail").html(html);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectdetailimg_Servlet",
            dataType: 'json',
            data : {"mall_id" :mall_id},
            success : function(data)
            {
                var length=data.length;
                var img1 = "";
                for(var i=0;i<length;i++){    //遍历data数组
                    var ls = data[i];
                    img1 +="<div class='lotimg'><img src="+ls.img_1+"></div>";
                    $(".detailimg_show").html(img1);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    };
    function takeorder(id) {
        window.location.href="takeorder.jsp?mall_id="+id+"";
    }
</script>
</body>
</html>
