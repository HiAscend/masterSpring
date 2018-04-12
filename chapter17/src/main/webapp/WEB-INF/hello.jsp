<%--
  Created by IntelliJ IDEA.
  User: ascend
  Date: 2018/4/12
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSocket测试</title>
    <script>
        const url = "ws://" + window.location.host + "<%=request.getContextPath()%>/hello";
        const socket = new WebSocket(url);

        socket.onopen = function () {
            console.log("开启客户端连接");
            sayHello();
        };

        socket.onmessage = function (e) {
            console.log("接收消息："+e.data);
            setTimeout(sayHello, 2000);
        };

        socket.onclose = function () {
            console.log("关闭socket连接");
        };
        function sayHello() {
            console.log("发送消息：Hello Server");
            socket.send("Hello Server");
        }

    </script>
</head>
<body>
<h1>WebSocket测试</h1>
</body>
</html>
