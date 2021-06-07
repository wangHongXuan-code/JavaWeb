#### ServletConfig
##### 1.作用
* ServletConfig对象是Servlet的专属配置对象，每个Servlet都单独拥有一个ServletConfig对象，用来获取web.xml中的配置信息
* Servlet特有信息配置方法：
```
<servlet>
    <init-param>
        <param-name></param-name>
        <param-value></param-value>
    </init-param>
</servlet>
```

##### 2.使用
* 获取ServletConfig对象
* 获取web.xml中的servlet配置信息