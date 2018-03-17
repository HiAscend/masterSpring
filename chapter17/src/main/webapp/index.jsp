<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
    pageContext.setAttribute("basePath", basePath);
%>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>练好本领，报国杀敌</title>
    <script type="text/javascript" src="${basePath}/resources/frame/jquery/jquery-1.12.4.js"></script>
<body>
<h2>Hello World!</h2>
<a href="${basePath}/a/user/handle511">handle511</a><br>

</body>
</html>
