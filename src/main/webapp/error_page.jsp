<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%@page errorPage="error_page.jsp" %>

<html>
<head>
    <title>ErrorPage</title>
</head>
<body>
<%@include file="header_back.jsp"%>
<h2>Что-то пошло не так</h2>
Текст исключения: <%= exception%>
</body>
</html>
