<%--
  Created by IntelliJ IDEA.
  User: ascend
  Date: 2018/03/12
  Time: 22:28
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
    <title>操作成功</title>
</head>
<body>
操作成功！
</body>
</html>
