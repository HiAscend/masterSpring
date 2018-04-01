<%--
  Created by IntelliJ IDEA.
  User: zziaa
  Date: 2018/03/28
  Time: 22:41
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
    <title><fmt:message key="website.title"/></title>
</head>
<body>
<fmt:message key="user.userList.title"/>
<table>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>
                <a href="<c:url value="/user/showUser/${user.userName}.html"/>">${user.userName}</a>
            </td>
            <td>
                ${user.realName}
            </td>
            <td>
                <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
