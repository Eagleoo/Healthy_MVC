<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加收货地址</title>
    <script src="public.js"></script>
    <link type="text/css" rel="stylesheet" href="reset.css">
    <link type="text/css" rel="stylesheet" href="main.css">
    <script src="jquery-3.3.1.js"></script>
</head>
<body>
<div class="insert_address_box">
    <br><br><br>
    <span class="name">详细地址：</span><input type="text" name="address" class="input_address" ></span><br><br>
    <span class="name">收件人姓名：</span><input type="text" name="consignee" class="input_address"><br><br>
    <span class="name">电话号码：</span><input type="text" name="cellnumber" class="input_address" maxlength="11"><br><br>
    <br>
    <input type="submit" value="添加" class="address_input_btn" onclick="insertaddr()"/>
</div>
<script>
    function insertaddr() {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/Insertaddress_Servlet",
            dataType: 'json',
            data : {"address" :$('input[name="address"]').val(),"consignee":$('input[name="consignee"]').val(),"cellnumber":$('input[name="cellnumber"]').val()},
            success : function(data)
            {
                alert(data[0].insertsuccess);
                window.location.href = document.referrer;
            },
            error : function()
            {
                alert("数据传输失败!");
            }
        });
    }
</script>
</body>
</html>
