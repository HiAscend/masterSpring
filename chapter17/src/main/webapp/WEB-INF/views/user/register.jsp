<%--
  Created by IntelliJ IDEA.
  User: ascend
  Date: 2018/03/06
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<form method="post" action="<c:url value='/user.html'/>">
    <table>
        <tr>
            <td><label for="user-name-label">用户名：</label> </td>
            <td><input type="text" name="userName" id="user-name-label"></td>
        </tr>
        <tr>
            <td><label for="password-label">密码：</label> </td>
            <td><input type="password" name="password" id="password-label"></td>
        </tr>
        <tr>
            <td><label for="realName-label">姓名：</label></td>
            <td><input type="text" name="realName" id="realName-label"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
