<%@ page import="com.example.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--
    使用传统方式获取作用域中的值
    缺点：
        1. 必须要导入包
        2. 进行类型的强制转化
        3. 层次结构比较复杂
    解决办法使用 EL表达式
-->
name:<%= request.getParameter("name") %>
pwd:<%= request.getParameter("pwd") %>
aa:<%= request.getAttribute("aa") %>
user:<%= ((User)request.getAttribute("user")).getAddress().getTown() %>
武安:<%= ((User)((ArrayList)request.getAttribute("list")).get(1)).getAddress().getTown() %>
map:<%= ((HashMap)request.getAttribute("map")).get("china") %>
map1:<%= ((User)((HashMap)request.getAttribute("map1")).get("a1")).getAddress().getTown() %>


<br>
<!--
    使用 EL表达式获取作用域中的值
-->
name:${param.name}
pwd:${param.pwd}
aa:${aa}
town:${user.address.town}
武安:${list[1].address.town}
map:${map.china}
map1:${map1.a1.address.town}

<br>

<!-- 使用EL表达式获取对象的顺序 -->
<%
    pageContext.setAttribute("key", "hello pageContext");
    request.setAttribute("key", "hello request");
    session.setAttribute("key", "hello session");
    application.setAttribute("key", "hello application");
%>
key:${key}<br>
pageContext:${pageScope.key}<br>
request:${requestScope.key}<br>
session:${sessionScope.key}<br>
application:${applicationScope.key}<br>

<!-- 使用 EL表达式进行基本运算 -->
${1 + 2}<br>
${1 - 2}<br>
${1 * 2}<br>
${1 / 2}<br>
${1 % 2}<br>
${1 > 2}<br>
${1 > 2 ? "男" : "女"}<br>
${1 + "2"}<br>

<!-- 获取请求头数据 -->
${header}<br>
${header["host"]}<br>
${headerValues["accept-language"][0]}<br>

<!-- 获取cookie数据 -->
${cookie}<br>
${cookie.JSESSIONID}<br>
${cookie.JSESSIONID.name}<br>
${cookie.JSESSIONID.value}<br>

<!-- EL表达式逻辑运算 -->
${true && false}<br>
${true && true}<br>
${true || false}<br>
${true || true}<br>

</body>
</html>
