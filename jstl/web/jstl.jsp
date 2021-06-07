<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension" %><%--
    JSTL
        帮助我们在jsp页面中添加复杂的逻辑判断,避免逻辑代码和页面标签混为一谈
        JSTL是EL的扩展,同时,JSTL依赖于EL,为了方便的从作用域中获取值

        JSTL的导入:
            添加jstl.jar,standard.jar添加到web-inf下的lib目录
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            配置该uri: Settings -> Languages & FrameWorks -> Schemes and DTDs -> 添加该uri,location为jstl
            文件下的tld中的c.tld
        标签分类：
            核心标签库：
            格式化标签库：
            函数标签库：
            XML标签库：
            SQL标签库：
        标签学习：   https://www.runoob.com/jsp/jsp-jstl.html
            <c:out value="哈哈"></c:out>  输出标签
                value: 填写要输出的值
                default: 默认值

            <c:set var="java" value="pageContext"></c:set>  向作用域设置属性值
                var: 表示参数的key
                value: 表示参数的值
                scope: 表示向哪个作用域设置属性值
                注意: 当只配置这两个属性的时候,默认是向pageContext作用域中设置属性,可以通过scope参数来做选择向哪个作用域设置

            <c:remove var="java"></c:remove>    删除作用域中的数据
                var: 表示参数的key
                scope: 删除指定作用域的数据
                注意: 如果没有指定scope属性,那么默认会把所有作用域中的参数都删除

            <c:if test="${a > 5}">  进行逻辑判断, if判断
                <h1>jstl is easy</h1>
            </c:if>
                test: 填写判断逻辑判断表达式
                var: 条件表达式的结果存储变量
                scope: 结果变量存储的作用域

            <c:choose>  进行多重逻辑判断,类似于switch
                <c:when test="${age < 10}">
                    <h1>小孩</h1>
                </c:when>
                <c:when test="${age < 20}">
                    <h1>青少年</h1>
                </c:when>
                <c:when test="${age < 30}">
                    <h1>青年</h1>
                </c:when>
                <c:when test="${age < 40}">
                    <h1>中年</h1>
                </c:when>
                <c:otherwise>
                    <h1>i don't konw</h1>
                </c:otherwise>
            </c:choose>

            <c:forEach begin="0" end="3" step="1" varStatus="str" var="i" items="${list}">  循环标签
                ${i}
            </c:forEach>
                begin: 起始值
                end: 结束值
                step: 步长
                varStatus: 循环状态的变量值名称
                var: 集合数据的每条记录的迭代值
                items: 从作用域中获取的数据
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("str", "happy");
        request.setAttribute("hello", "world");
        request.setAttribute("java", "1234");
    %>
    <c:out value="哈哈" default="嘿嘿"></c:out><br>
    <c:out value="${str}" default="嘿嘿"></c:out><br>

    <!-- 向作用域设置属性值 -->
    <c:set var="java" value="pageContext" scope="page"></c:set>
    <c:set var="java" value="request" scope="request"></c:set>
    <c:set var="java" value="session" scope="session"></c:set>
    <c:set var="java" value="application" scope="application"></c:set>

    <c:out value="${java}"></c:out><br>
    <c:out value="${pageScope.java}"></c:out><br>
    <c:out value="${requestScope.java}"></c:out><br>
    <c:out value="${sessionScope.java}"></c:out><br>
    <c:out value="${applicationScope.java}"></c:out><br>

    <!-- 删除作用域的数据 -->
    <c:remove var="java"></c:remove>
    <c:out value="${java}"></c:out>

    <!-- 逻辑判断标签 -->
    <c:set var="a" value="6"></c:set>
    <c:if test="${a > 5}" var="file" scope="request">
        <h1>jstl is easy</h1>
    </c:if>
    <c:set var="age" value="15"></c:set>
    <c:choose>
        <c:when test="${age < 10}">
            <h1>小孩</h1>
        </c:when>
        <c:when test="${age < 20}">
            <h1>青少年</h1>
        </c:when>
        <c:when test="${age < 30}">
            <h1>青年</h1>
        </c:when>
        <c:when test="${age < 40}">
            <h1>中年</h1>
        </c:when>
        <c:otherwise>
            <h1>i don't konw</h1>
        </c:otherwise>
    </c:choose>

    <!-- 循环标签 -->
    <table border="1px">
        <tr>
            <td>1</td>
            <td>111</td>
        </tr>
        <tr>
            <td>2</td>
            <td>222</td>
        </tr>
        <tr>
            <td>3</td>
            <td>333</td>
        </tr>
    </table>
    <c:forEach begin="0" end="3" step="1" varStatus="str">
        ${str.index}---${str.count}---${str.first}---${str.last}<br>
    </c:forEach>
    <%
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list", list);

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "111");
        map.put("2", "222");
        map.put("3", "333");
        request.setAttribute("map", map);
    %>
    <c:forEach begin="0" end="3" step="1" varStatus="str" var="i" items="${list}">
        ${i}
    </c:forEach>
    <table border="1px">
        <c:forEach begin="0" end="2" step="1" var="i" items="${map}">
            <tr>
                <td>${i.key}</td>
                <td>${i.value}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
