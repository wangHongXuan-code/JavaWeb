<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/5/16
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <b>我是转发页面</b>
    <%= request.getParameter("china") %>
    <hr>
    <%= request.getParameter("hebei")%>
</body>
</html>
