<%--
  Created by IntelliJ IDEA.
  User: zziaa
  Date: 2018/03/25
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
    pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>新增用户</title>
    <style>
        .errorClass {
            color: red;
        }
    </style>
</head>
<body>

<spring:bind path="user.*">
    <c:forEach var="error" items="${status.errorMessage}">
        <b><c:out value="${error}"/></b>
    </c:forEach>
</spring:bind>

<form:form commandName="user" action="/chapter17/user/handle92.html">
    <%--显示表单对象的所有错误信息--%>
    <%--<form:errors path="*" cssClass="errorClass" element="div"/>--%>
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <form:errors path="userName" cssClass="errorClass" element="div"/>
                <form:input path="userName"/>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <form:errors path="password" cssClass="errorClass" element="div"/>
                <form:input path="password"/>
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <form:errors path="realName" cssClass="errorClass" element="div"/>
                <form:input path="realName"/>
            </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td>
                <form:errors path="birthday" cssClass="errorClass" element="div"/>
                <form:input path="birthday"/>
            </td>
        </tr>
        <tr>
            <td>工资：</td>
            <td>
                <form:errors path="salary" cssClass="errorClass" element="div"/>
                <form:input path="salary"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="提交">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
