<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="main.css">
    <link type="text/css" rel="stylesheet" href="reset.css">
    <script src="jquery-3.3.1.js"></script>
    <title>登录</title>
</head>
<body class="Login_body">
<div class="Login_back">
    <div class="Login_title">
        <h3>欢迎登录A+健康</h3>
    </div>
    <input type="text" name="username" class="input_loginUtxt" placeholder="username"/>
    <br>
    <br>
    <br>
    <input type="password" name="password"  class="input_loginPtxt" placeholder="password">
    <br>
    <br>
    <br>
    <input type="button" onclick="login()" name="submit" value="sign up" class="input_login"/>
</div>
<script>
    function login() {
        $.ajax({
            type : "post",
            url : "http://localhost:8080/LoginServlet",
            dataType: 'json',
            data : {"username" :$(".input_loginUtxt").val(),"password":$(".input_loginPtxt").val()},
            success : function(data)
            {
                alert(data[0].loginsuccess);
                if (data[0].loginsuccess=="登录成功"){
                    window.location.href = document.referrer;
                }
                else if(data[0].loginsuccess=="admin登录成功")
                {
                    window.location.href="manager.jsp";
                }



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
