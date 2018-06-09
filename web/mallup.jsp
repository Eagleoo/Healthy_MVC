<%@ page import="javafx.application.Application" %>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<link type="text/css" rel="stylesheet" href="main.css">
<script src="jquery-3.3.1.js"></script>
<html>
<body>
<div class="upload_form">
<form action="Insertmall_Servlet" method="post" enctype="multipart/form-data" onsubmit="return check()">
    <br><br><br>
    <span class="name">商品名称：</span><input type="text" name="mall_name" class="input_mall" maxlength="8">&ensp;<span>不超过8个字符</span><br><br>
    <span class="name">商品描述：</span><input type="text" name="mall_describe" class="input_mall" maxlength="13">&ensp;<span>不超过13个字符</span><br><br>
    <span class="name">商品价格：</span><input type="text" name="mall_price" class="input_mall"><br><br>
    <span class="name">商品类型：</span><input list="listitem" name="mall_type" class="input_mall" id="input_type">&ensp;<span>请选择类型</span><br><br>
    <span class="name">选择商品图片  ：</span><input type="file" name="pic" id="input_img" ><br>
    <span class="name">选择详情图片1：</span><input type="file" name="pic1" id="input_img1" ><br>
    <span class="name">选择详情图片2：</span><input type="file" name="pic2" id="input_img2" ><br>
    <span class="name">选择详情图片3：</span><input type="file" name="pic3" id="input_img3" ><br>
    <span class="name">选择详情图片4：</span><input type="file" name="pic4" id="input_img4" ><br>
    <span class="name">选择详情图片5：</span><input type="file" name="pic5" id="input_img5" ><br>
    <span class="name">选择详情图片6：</span> <input type="file" name="pic6" id="input_img6" ><br>
    <br>
    <input type="submit" value="上传" class="input_btn"/>
</form>
</div>

<datalist id="listitem" style="background-color: black">
    <option>智能硬件</option>
    <option>保险产品</option>
    <option>运动健身</option>
    <option>血压血糖</option>
    <option>优惠套餐</option>
    <option>保健药品</option>

</datalist>
<script>
    function  check() {
        var file1 = document.getElementById('input_img');
        var file2 = document.getElementById('input_img1');
        var file3 = document.getElementById('input_type');
        if ($(".input_mall").val()==""){
            alert("不能为空哦！");
            return false;
        }
        if(file1.value=="")
        {
            alert("请选择商品图片");
            return false;
        }
        if(file2.value=="")
        {
            alert("请选择商品详情图片");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
