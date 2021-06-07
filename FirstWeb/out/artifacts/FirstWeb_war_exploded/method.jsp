<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/5/10
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="response" method="get">
        用户名: <input type="text" name="name" value=""/><br/>
        密码: <input type="text" name="pwd" value=""><br/>
        爱好: <br/>
        <input type="checkbox" name="fav" value="1"/>java
        <input type="checkbox" name="fav" value="2"/>php
        <input type="checkbox" name="fav" value="3"/>c#
        <input type="submit" value="登录">
    </form>
</body>
</html>
