#### 思考：
* 不同用户的数据共享怎么办？
* 比如，浏览一些技术网站的时候，xxx帖子多少人访问
* 使用ServletContext来处理
#### 什么是ServletContext?
* 运行在JVM上的每一个web应用程序都有一个与之对应的Servlet上下文（Servlet运行环境）
* Servlet API提供ServletContext接口用来表示Servlet上下文，ServletContext对象可以被web应用程序中的所有servlet访问
* ServletContext对象是web服务器中的一个已知路径的根
#### ServletContext原理?
* ServletContext对象由服务器进行创建，一个项目只有一个对象。不管在项目的任意位置进行获取得到的都是同一个对象，那么不同用户发起的请求获取到的也就是同一个对象了，该对象由用户共同拥有。

