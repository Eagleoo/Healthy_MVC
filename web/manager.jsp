<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <link type="text/css" rel="stylesheet" href="main.css">
    <link type="text/css" rel="stylesheet" href="reset.css">
    <script src="jquery-3.3.1.js"></script>
</head>
<body>
<div class="manager_left">
    <div class="manager_mallnav">
        <ul>
            <li ><a href="#" onclick="showAtRight1('/mallup.jsp')"><span>商品上架</span></a></li>
            <li ><a href="#" onclick="showAtRight2('/malldown.jsp')"><span>商品下架</span></a></li>
            <li ><a href="#" onclick="showAtRight3('/order_manager.jsp')"><span>订单管理</span></a></li>
            <li ><a href="#" onclick="showAtRight4('/logistics.jsp')"><span>物流管理</span></a></li>
            <li ><a href="#" onclick="showAtRight()"><span>商品下架</span></a></li>
            <li ><a href="#" onclick="showAtRight()"><span>商品下架</span></a></li>
        </ul>
    </div>
</div>
<div class="manager_right">
</div>
<script>
    function showAtRight1(url) {
        $.ajax({
            type :"GET",
            url :url,
            dataType:"html",
            success : function(data) {
                $(".manager_right").html(data);
            },
            error:function(){
                $(".manager_right").html("获取数据失败！");
            }
        });
    }
    function showAtRight2(url){
        showAtRight1(url);
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectallmall_Servlet",
            dataType: 'json',
            success : function(data)
            {
                var length=data.length;
                var html = "";
                for(var i=0;i<length;i++)
                {
                    var ls = data[i];
                    html="<tr><td class='mall_id'>"+ls.mall_id+"</td><td>"+ls.mall_name+"</td><td>"+ls.mall_describe+"</td>" +
                        "<td>"+ls.mall_price+"</td><td><input type='button' value='下架' onclick='downmall(this)'>" +
                        "<input type='button' value='修改'></tr>";
                    $(".malldown_table").append(html);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    }
    function showAtRight3(url){
        showAtRight1(url);
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectorder_Servlet",
            dataType: 'json',
            success : function(data)
            {
                var length=data.length;
                var html = "";
                for(var i=0;i<length;i++)
                {
                    var ls = data[i];
                    html="<tr><td>"+ls.order_id+"</td><td>"+ls.username+"</td><td>"+ls.mall_id+"</td>" +
                        "<td>"+ls.order_count+"</td><td>"+ls.order_allprice+"</td><td>"+ls.consignee+"</td>"+
                        "<td>"+ls.cellnumber+"</td><td>"+ls.address+"</td><td>"+ls.ispay+"</td>"+
                        "<td>"+ls.issend+"</td><td>"+ls.isreceive+"</td>"+
                        "<td><input id='order_delete' type='button' value='删除' onclick='downorder(this)'>" +
                        "<input id='order_change' type='button' value='修改' onclick='tabletoinput(this)'></td></tr>";
                    $(".order_manager_table").append(html);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    }
    function showAtRight4(url) {
        showAtRight1(url);
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Selectorder_Servlet",
            dataType: 'json',
            success : function(data)
            {
                var length=data.length;
                var html = "";
                for(var i=0;i<length;i++)
                {
                    var ls = data[i];
                    html="<tr><td>"+ls.order_id+"</td><td>"+ls.username+"</td><td>"+ls.mall_id+"</td>" +
                        "<td>"+ls.order_count+"</td><td>"+ls.order_allprice+"</td><td>"+ls.consignee+"</td>"+
                        "<td>"+ls.cellnumber+"</td><td>"+ls.address+"</td>"+
                        "<td>"+ls.l_time+"</td><td>"+ls.l_add+"</td>"+
                        "<td><input id='order_delete' type='button' value='删除' onclick='downorder(this)'>" +
                        "<input id='order_change' type='button' value='修改' onclick='tabletoinput(this)'></td></tr>";
                    $(".logistics_table").append(html);
                }
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    }

    function downmall(obj) {
        var x = $(obj).parent().parent().find("td");
        var y = x.eq(0).text();
        $.ajax({
            type : "post",
            async: false,
            url : "http://localhost:8080/Deletemall_Servlet",
            data: {"mall_id":y},
            dataType: 'json',
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
        window.location.reload()
    }
    function downorder(obj) {
        var x = $(obj).parent().parent().find("td");
        var y = x.eq(0).text();
        $.ajax({
            type : "post",
            async: false,
            url : "http://localhost:8080/Deleteorder_Servlet",
            data: {"order_id":y},
            dataType: 'json',
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
        window.location.reload()
    }
    function tabletoinput(obj) {
        str = $(obj).val();
        if (str=="修改") {
            $(obj).val("确定");
            for (i=0;i<11;i++)
                $(obj).parent(i).parent().find("td").eq(i).html("<input class='order_change_input' type='text' value='"+$(obj).parent().parent().find("td").eq(i).text()+"'>")
        }
        else{
            $(obj).val("修改");
            var d0=$(obj).parent().parent().find("input").eq(0).val();
            var d1=$(obj).parent().parent().find("input").eq(1).val();
            var d2=$(obj).parent().parent().find("input").eq(2).val();
            var d3=$(obj).parent().parent().find("input").eq(3).val();
            var d4=$(obj).parent().parent().find("input").eq(4).val();
            var d5=$(obj).parent().parent().find("input").eq(5).val();
            var d6=$(obj).parent().parent().find("input").eq(6).val();
            var d7=$(obj).parent().parent().find("input").eq(7).val();
            var d8=$(obj).parent().parent().find("input").eq(8).val();
            var d9=$(obj).parent().parent().find("input").eq(9).val();
            var d10=$(obj).parent().parent().find("input").eq(10).val();

            $(".order_change_input").remove();
            $(obj).parent().parent().find("td").eq(0).html(d0);
            $(obj).parent().parent().find("td").eq(1).html(d1);
            $(obj).parent().parent().find("td").eq(2).html(d2);
            $(obj).parent().parent().find("td").eq(3).html(d3);
            $(obj).parent().parent().find("td").eq(4).html(d4);
            $(obj).parent().parent().find("td").eq(5).html(d5);
            $(obj).parent().parent().find("td").eq(6).html(d6);
            $(obj).parent().parent().find("td").eq(7).html(d7);
            $(obj).parent().parent().find("td").eq(8).html(d8);
            $(obj).parent().parent().find("td").eq(9).html(d9);
            $(obj).parent().parent().find("td").eq(10).html(d10);

            // alert(d0+d1+d2+d3+d4+d5+d6+d7+d8+d9+d10);
            $.ajax({
                type : "post",
                url : "http://localhost:8080/Updateorder_Servlet",
                dataType: 'json',
                data:{"order_id":d0,"username":d1,"mall_id":d2,"mall_count":d3,"order_allprice":d4,"consignee":d5,"cellnumber":d6,"address":d7,"ispay":d8,"issend":d9,"isreceive":d10},
                success : function(data)
                {
                    alert(data[0].success);
                },
                error : function()
                {
                    alert("数据传输失败!");
                }
            });

        }
    }

</script>
</body>
</html>
