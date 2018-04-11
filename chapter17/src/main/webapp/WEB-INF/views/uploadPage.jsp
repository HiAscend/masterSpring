<%--
  Created by IntelliJ IDEA.
  User: zziaa
  Date: 2018/04/11
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请上传用户头像</title>
</head>
<body>
    <h1>请选择上传头像文件</h1>
    <form method="post" action="<c:url value="/user/uploadThumb.html"/>" enctype="multipart/form-data">
        <input type="text" name="username">
        <input type="file" name="file">
        <input type="submit">
    </form>


</body>
</html>
