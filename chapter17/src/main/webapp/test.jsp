<!DOCTYPE HTML>
<%--
  Created by IntelliJ IDEA.
  User: zziaa
  Date: 2018/04/15
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>静态资源测试页面</title>
    <%--引用ResourcePathExposer通过ServletContex暴露的resourceRoot属性值--%>
    <script src="${resourceRoot}/js/test.js" type="text/javascript"></script>
</head>
<body>
<script>
    test();
</script>
</body>
</html>
