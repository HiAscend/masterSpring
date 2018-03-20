<%--
  Created by IntelliJ IDEA.
  User: ascend
  Date: 2018/03/08
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
    pageContext.setAttribute("basePath",basePath);
%>
<html>
<head>
    <title>用户创建成功</title>
</head>
<body>
<%--访问Model中的属性--%>
恭喜，用户${user.userName}创建成功，用户的id为${user.userId}。
恭喜，用户${myUser.userName}创建成功，用户的id为${myUser.userId}。
</body>
</html>
