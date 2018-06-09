<%@ page contentType="text/html;charset=GB2312" language="java" %>
<html>
<head>
    <title>��̨����</title>
    <link type="text/css" rel="stylesheet" href="main.css">
    <link type="text/css" rel="stylesheet" href="reset.css">
    <script src="jquery-3.3.1.js"></script>
</head>
<body>
<div class="manager_left">
    <div class="manager_mallnav">
        <ul>
            <li ><a href="#" onclick="showAtRight1('/mallup.jsp')"><span>��Ʒ�ϼ�</span></a></li>
            <li ><a href="#" onclick="showAtRight2('/malldown.jsp');"><span>��Ʒ�¼�</span></a></li>
            <li ><a href="#" onclick="showAtRight()"><span>��������</span></a></li>
            <li ><a href="#" onclick="showAtRight()"><span>Ȧ�ӹ���</span></a></li>
            <li ><a href="#" onclick="showAtRight()"><span>��Ʒ�¼�</span></a></li>
            <li ><a href="#" onclick="showAtRight()"><span>��Ʒ�¼�</span></a></li>
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
                $(".manager_right").html("��ȡ����ʧ�ܣ�");
            }
        });
    }
    function showAtRight2(url){
        $.ajax({
            type :"GET",
            url :url,
            dataType:"html",
            success : function(data) {
                $(".manager_right").html(data);

            },
            error:function(){
                $(".manager_right").html("��ȡ����ʧ�ܣ�");
            }
        });
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
                        "<td>"+ls.mall_price+"</td><td><input type='button' value='�¼�' onclick='getid(this)'>" +
                        "</input><input type='button' value='�޸�'></input></tr>";
                    $(".malldown_table").append(html);
                }
            },
            error : function()
            {
                alert("���ݴ���ʧ��!");
            }
        });
    }
    function getid(obj) {
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
</script>
</body>
</html>
