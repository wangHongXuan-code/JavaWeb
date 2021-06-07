<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/5/16
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<base href="<%= basePath %>">
aaaaa
<a href="page.jsp">page</a>
</body>
</html>
