<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("USER");
    if (username == null || "".equals(username)){
        List<String> list = new ArrayList<>();
        list.add("必须登录才能访问主页面！");
        request.setAttribute("error",list);
        request.getRequestDispatcher("error.jsp").forward(request,response);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主页面欢迎您!&nbsp;&nbsp;&nbsp;&nbsp;<%=username%></h1>
</body>
</html>
