<%--
  Created by IntelliJ IDEA.
  User: zziaa
  Date: 2018/04/01
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "";
    pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<form:form  commandName="user" action="${url}" >
    <table>
        <tr>
            <td>用户名：</td>
            <td><form:input path="userName" /></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><form:password path="password"  /></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><form:input path="realName" /></td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><form:input path="birthday" /></td>
        </tr>
        <tr>
            <td>工资：</td>
            <td><form:input path="salary" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
