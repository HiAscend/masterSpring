<%--
  Created by IntelliJ IDEA.
  User: ascend
  Date: 2018/3/21
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
    pageContext.setAttribute("basePath",basePath);
%>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
userName:${myUser.userName}
userId:${myUser.userId}
password:${myUser.password}
realName:${myUser.realName}
testAttr:${testAttr}
</body>
</html>
