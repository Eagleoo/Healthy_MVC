<%@ page import="javafx.application.Application" %>
<%@ page contentType="text/html;charset=GB2312" language="java" %>
<link type="text/css" rel="stylesheet" href="main.css">
<script src="jquery-3.3.1.js"></script>
<html>
<body>
<div class="upload_form">
<form action="Insertmall_Servlet" method="post" enctype="multipart/form-data" onsubmit="return check()">
    <br><br><br>
    <span class="name">��Ʒ���ƣ�</span><input type="text" name="mall_name" class="input_mall" maxlength="8">&ensp;<span>������8���ַ�</span><br><br>
    <span class="name">��Ʒ������</span><input type="text" name="mall_describe" class="input_mall" maxlength="13">&ensp;<span>������13���ַ�</span><br><br>
    <span class="name">��Ʒ�۸�</span><input type="text" name="mall_price" class="input_mall"><br><br>
    <span class="name">��Ʒ���ͣ�</span><input list="listitem" name="mall_type" class="input_mall" id="input_type">&ensp;<span>��ѡ������</span><br><br>
    <span class="name">ѡ����ƷͼƬ  ��</span><input type="file" name="pic" id="input_img" ><br>
    <span class="name">ѡ������ͼƬ1��</span><input type="file" name="pic1" id="input_img1" ><br>
    <span class="name">ѡ������ͼƬ2��</span><input type="file" name="pic2" id="input_img2" ><br>
    <span class="name">ѡ������ͼƬ3��</span><input type="file" name="pic3" id="input_img3" ><br>
    <span class="name">ѡ������ͼƬ4��</span><input type="file" name="pic4" id="input_img4" ><br>
    <span class="name">ѡ������ͼƬ5��</span><input type="file" name="pic5" id="input_img5" ><br>
    <span class="name">ѡ������ͼƬ6��</span> <input type="file" name="pic6" id="input_img6" ><br>
    <br>
    <input type="submit" value="�ϴ�" class="input_btn"/>
</form>
</div>

<datalist id="listitem" style="background-color: black">
    <option>����Ӳ��</option>
    <option>���ղ�Ʒ</option>
    <option>�˶�����</option>
    <option>ѪѹѪ��</option>
    <option>�Ż��ײ�</option>
    <option>����ҩƷ</option>

</datalist>
<script>
    function  check() {
        var file1 = document.getElementById('input_img');
        var file2 = document.getElementById('input_img1');
        var file3 = document.getElementById('input_type');
        if ($(".input_mall").val()==""){
            alert("����Ϊ��Ŷ��");
            return false;
        }
        if(file1.value=="")
        {
            alert("��ѡ����ƷͼƬ");
            return false;
        }
        if(file2.value=="")
        {
            alert("��ѡ����Ʒ����ͼƬ");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
