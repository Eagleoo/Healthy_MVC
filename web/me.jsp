<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="reset.css">
    <link type="text/css" rel="stylesheet" href="main.css">
    <script src="jquery-3.3.1.js"></script>
</head>
<header>
    <div class="topBar">
        <div class="leftArea">
            <a href="mall_collect.jsp" class="collection">收藏</a>
        </div>
        <div class="rightArea">
            欢迎来到health     <a href="login.jsp" id="login_a">[登 录]</a><a href="#" id="rigist_a">[注 册]</a>
        </div>
    </div>
</header>
<body>
<div class="me_left">
    <ul class="me_left_ul">
        <li><a href="me.jsp">我的订单>></a></li>
        <li><a href="mall_collect.jsp">我的收藏>></a></li>
        <li><a href="index.jsp">返回首页>></a></li>
    </ul>
</div>

<div class="me_right">
    <div class="me_right_box">
        <div class="me_right_nav">
            <ul id="me_right_ul">
                <li><input type="button" value="全部订单" onclick="showorderall()"></li>
                <li><input type="button" value="待付款" onclick="showorderbytype('ispay')"></li>
                <li><input type="button" value="待发货" onclick="showorderbytype('issend')" ></li>
                <li><input type="button" value="待收货" onclick="showorderbytype('isreceive') "></li>
            </ul>
        </div>
        <table class="me_right_table">
            <tr>
                <th>商品</th>
                <th>单价</th>
                <th>数量</th>
                <th>总价</th>
                <th>操作</th>
            </tr>
        </table>
    </div>
</div>
<div class="logistics_show">
    <div id="formhead">
        <div id="formhead-title">订单信息</div>
        <button type="button" id="close" onclick="closelogistics()">X</button>
    </div>
    <div id="formbody">
    </div>
</div>
<script>
    window.onload=function checklogin(){
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Checklogin_Servlet",
            dataType: 'json',
            success : function(data)
            {
                if (data[0].user!=null)
                {
                    $("#login_a").html("["+data[0].user+"]").attr("href","#");
                    $("#rigist_a").html("[退出]").attr("onclick","exitlogin()")
                }
                else {
                    window.open("login.jsp","_self");
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
        showorderall();
    };
    function closelogistics() {
        $(".logistics_show").fadeOut("slow");
    }
    function exitlogin() {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Exitlogin_Servlet",
            dataType: 'json',
            success : function(data)
            {

                alert(data[0].exit);
                location.reload()

            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });

    }
    function showorderall() {
        $(".me_right_table tr:not(:first)").remove();
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectorderbyusername_Servlet",
            dataType: 'json',
            success : function(data)
            {
                var length=data.length;
                var html = "";
                var state="";
                for(var i=0;i<length;i++){    //遍历data数组
                    var ls = data[i];
                    if (ls.ispay == "F"&&ls.issend=="F"&&ls.isreceive=="F" )
                    {
                        state="付款";
                    }
                    else if (ls.ispay == "T" && ls.issend=="F" && ls.isreceive=="F" )
                    {
                        state="等待发货";
                    }
                    if (ls.ispay=="T" && ls.issend=="T" && ls.isreceive=="F" )
                    {
                        state="收货";
                    }
                    if (ls.ispay=="T" && ls.issend=="T" && ls.isreceive=="T" )
                    {
                        state="订单完成";
                    }
                    html=
                        "<tr><div><td><img src="+ls.mall_img+"><p><em>订单号：</em><em id='order_id'>"+ls.order_id+"</em></p></div></td><td>"+ls.mall_price+"</td>" +
                        "<td>"+ls.order_count+"</td><td>"+ls.order_allprice+"</td>" +
                        "<td><input class='order_operarte' type='button' value='"+state+"' onclick='allorderaddfunction(this)'><input class='order_operarte' type='button' value='查看物流' onclick='looklogistics(this)'></td></tr>";
                    $(".me_right_table").append(html);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }
    function allorderaddfunction(obj) {
        var state=$(obj).val();
        if (state=="付款")
        {
            changepay(obj);
            showorderbytype("issend")
        }
        else if (state == "收货")
        {
            changereceive(obj);
            showorderbytype("isreceive")
        }
    }
    function showorderbytype(iswhat) {
        $(".me_right_table tr:not(:first)").remove();
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectorderbyusername_Servlet",
            dataType: 'json',
            data:{"iswhat":iswhat},
            success : function(data)
            {
                var length=data.length;
                var html = "";
                if (iswhat=="ispay"){
                for(var i=0;i<length;i++){
                    var ls = data[i];
                    html=
                        "<tr><div><td><img src="+ls.mall_img+"><p><em>订单号：</em><em id='order_id'>"+ls.order_id+"</em></p><p>"+ls.mall_describe+"</p></div></td><td>"+ls.mall_price+"</td>" +
                        "<td>"+ls.order_count+"</td><td>"+ls.order_allprice+"</td>" +
                        "<td><input class='order_operarte' type='button' value='付款' onclick='changepay(this)'>" +
                        "<input class='order_operarte' type='button' value='查看物流' onclick='looklogistics(this)'></td>" +
                        "</tr>";
                    $(".me_right_table").append(html);
                }
                }
                else if(iswhat=="issend"){
                    for(var i=0;i<length;i++){
                        var ls = data[i];
                        html=
                            "<tr><div><td><img src="+ls.mall_img+"><p><em>订单号：</em><em id='order_id'>"+ls.order_id+"</em></p><p>"+ls.mall_describe+"</p></div></td><td>"+ls.mall_price+"</td>" +
                            "<td>"+ls.order_count+"</td><td>"+ls.order_allprice+"</td>" +
                            "<td><input class='order_operarte' type='button' value='等待发货'>" +
                            "<input class='order_operarte' type='button' value='查看物流' onclick='looklogistics(this)'></td></tr>";
                        $(".me_right_table").append(html);
                    }
                }
                else if(iswhat=="isreceive"){
                    for(var i=0;i<length;i++){
                        var ls = data[i];
                        html=
                            "<tr><div><td><img src="+ls.mall_img+"><p><em>订单号：</em><em id='order_id'>"+ls.order_id+"</em></p><p>"+ls.mall_describe+"</p></div></td><td>"+ls.mall_price+"</td>" +
                            "<td>"+ls.order_count+"</td><td>"+ls.order_allprice+"</td>" +
                            "<td><input class='order_operarte' type='button' value='收货' onclick='changereceive(this)'>" +
                            "<input class='order_operarte' type='button' value='查看物流' onclick='looklogistics(this)'></td></tr>";
                        $(".me_right_table").append(html);
                    }
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);

                alert(textStatus);
            }
        });
    }
    function changepay(obj) {
        var order_id=$(obj).parent().parent().find("#order_id").text();
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Changeorderstate_Servlet",
            dataType: 'json',
            data:{"order_id":order_id,"dowhat":"pay"},
            success : function(data)
            {
                alert(data[0].success);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }
    function changereceive(obj) {
        var order_id=$(obj).parent().parent().find("#order_id").text();
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Changeorderstate_Servlet",
            dataType: 'json',
            data:{"order_id":order_id,"dowhat":"receive"},
            success : function(data)
            {
                alert(data[0].success);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }
    function looklogistics(obj) {
        var order_id=$(obj).parent().parent().find("#order_id").text();
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectlogistics_Servlet",
            dataType: 'json',
            async: false,
            data:{"order_id":order_id,"roof":"web"},
            success : function(data)
            {
                $(".logistics_show").fadeIn("slow");
                var length=data.length;
                var html = "";
                    for(var i=0;i<length;i++){
                        var ls = data[i];
                        html += "<p style='color: white'>"+ls.l_time+"</p><p style='color: white'>"+ls.l_add+"</p><br>";
                        $("#formbody").html(html);
                    }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        });
    }
</script>
</body>
</html>