<%--
  page:
    用来设置转译成servlet文件时的参数
    contentType: 表示浏览器解析相应信息的时候使用的编码和解析格式
    language: 表示jsp要转译成的文件类型
    import: 导入需要的jar包,多个包使用","分割
    pageEncoding: 设置页面的编码格式 如果pageEncoding和contentType同时设置,必须保持一致
    session: 用来控制servlet中是否有session对象
    errorPage: 当页面发生逻辑错误的时候跳转的页面
    extends: 手动指定要转译的servlet类继承的父类(包名+类名)

  局部代码块:
    可以将Java代码跟页面展示的标签写到一个jsp页面中,Java代码转译成的servlet文件中,
    Java代码跟输出是保存在service方法中的
    缺点:
        代码可读性比较差,开发比较麻烦
        一般不使用

  全局代码块:
    定义公共的方法的时候需要使用全局代码块 <%! %>
    生成的代码在servlet类中
    调用的时候需要使用局部代码块

  脚本调用方式
    使用<%= %>直接调用变量和方法(方法必须有返回值)
    注意: 不能在变量或方法的后面添加;

  页面导入方式
    1.静态导入:
    <%@ include file="staticImport.jsp"%> file中填写的是jsp文件的相对路径
    不会将静态导入的页面生成一个新的servlet文件,而是将两个文件合并
    优点：运行效率高
    缺点：两个页面会耦合到一起,不利于维护,两个页面中不能存在相同名称的变量名
    2.动态导入:
    <jsp:include page="dynamicImport.jsp"></jsp:include>
    两个页面不会进行合并,分别生成自己的servlet文件,但是页面在最终展示的时候是合并到一起的
    优点：没有耦合,可以存在同名的变量

  请求转发:
    在jsp中也可以使用servlet的请求转发功能
    <jsp:forward page="forward.jsp"></jsp:forward> page中填写的是jsp文件的相对路径
    注意：在标签中间不可以添加任何字符,除了<jsp:param name="china" value="beijing"/>方式
    在转发的页面中想要获取到属性值通过 request.getParameter(String name)

  Jsp九大内置对象:
    jsp页面在转译成其对应的servlet文件的时候,会自动声明一些对象,在jsp页面中可以直接使用
    注意：内置对象是在jsp页面中使用的,可以在局部代码块中使用,也可以在脚本段语句中使用,但是不能在全局代码块中使用
    九大对象:
        pageContext：表示页面的上下文对象,封存了当前页面的运行信息和其他内置对象
                     注意：每一个页面都有一个对应的 pageContext 对象,伴随着当前页面的结束而结束
        request：封装当前请求的数据,由tomcat创建,一个请求对应一个request对象
        session：用来封装同一个用户的不同请求的共享数据,一次会话对应一个session对象
        application：相当于ServletContext对象,一个web项目只有一个对象,存储着所有用户的共享数据,从服务器启动到服务器结束
        response：响应对象,用来相应请求数据,将处理结果返回给浏览器,可以进行重定向
        out：响应对象,jsp内部使用,带有缓冲区的响应对象,效果高于response
        page：代表当前jsp对象,跟Java中的this指针类似
        exception：异常对象,存储当前运行的异常信息,必须在page指令中添加属性 isErrorPage="true",该对象才会被创建
        config：相当于ServletConfig对象,用来获取web.xml中配置的数据,完成servlet的初始化操作
    四大作用域:
        pageContext：表示当前页面,解决当前页面内的数据共享问题,获取其他内置对象
        request：一次请求,一次请求的servlet的数据共享,通过请求转发的方式,将数据流转到下一个servlet
        session：一次会话,一个用户发送的不同请求之间的数据共享,可以将数据从一个请求流转到其他请求
        application：项目内,不同用户的数据共享问题,将数据从一个用户流转到其他用户
    路径问题:
        想要获取项目中的资源,可以使用相对路径,也可以使用绝对路径
        相对路径：相对于当前页面的路径
            问题：1. 资源的位置不可以随便更改
                 2. 需要使用../的方式进行文件夹的跳出,如果目录结果比较深,可能操作起来比较麻烦
        绝对路径：在请求路径的前面加 /,表示当前服务器的根路径,使用的时候要添加/虚拟项目名称/资源目录
        使用jsp中自带的全局路径声明：
            <%
                String basePath = request.getScheme() + "://" + request.getServerName() + ":"
                        + request.getServerPort() + request.getContextPath() + "/";
            %>
            <base href="<%= basePath %>">
            添加资源路径的时候,从当前项目的web目录下添加即可


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, java.lang.*" pageEncoding="utf-8" %>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" isErrorPage="true" %>

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
    全局代码块:
    <%!
        public void test() {
            System.out.println("我是全局代码块");
        }
    %>
    <%
        // int i = 5 / 0;
    %>
    局部代码块:
    <%
        int i = new Random().nextInt(10);
        if (i > 5) {
    %>
    <b>今天天气真好</b>
    <% } else { %>
    <b>今天天气不好</b>
    <% } %>

    调用局部代码块:
    <% test(); %>

    <% String str = "脚本调用"; %>
    <%= str %>

    <%@ include file="staticImport.jsp"%>
    <jsp:include page="dynamicImport.jsp"></jsp:include>

<%--    <jsp:forward page="forward.jsp">--%>
<%--        <jsp:param name="china" value="beijing"/>--%>
<%--        <jsp:param name="hebei" value="shijiazhuang"/>--%>
<%--    </jsp:forward>--%>

<%--    <%--%>
<%--        response.sendRedirect("forward.jsp");--%>
<%--    %>--%>

    <a href="a/a.jsp">aaa</a>
    <a href="b/b.jsp">bbb</a>

</body>
</html>
