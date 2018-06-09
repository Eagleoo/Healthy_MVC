<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
    List<String> list =
            (List<String>) request.getAttribute("error");
    response.setHeader("refresh","5,URL=index.html");

%>
<html>
<body>
<h2>5秒钟后跳转到登录页面，否则<a href="index.html" style="color:red">点我</a></h2>
<%
    if (list != null){
        for (int i=0;i<list.size();i++){
%>
    <h3><%= list.get(i)%></h3>
<%
        }
    }
%>
</body>
</html>
