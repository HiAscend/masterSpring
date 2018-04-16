<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
    pageContext.setAttribute("basePath", basePath);
%>
<html lang="zh-cmn-Hans">
<body>
<h2>Hello World!</h2>
</body>
</html>
