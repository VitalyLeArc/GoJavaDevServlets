<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: Yume
  Date: 01.08.2020
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>salarysum</title>
</head>
<body>
<%@include file="header_back.jsp"%>
<br/>
sum salary = <%
    out.println((BigDecimal)request.getAttribute("projectdevssalarysum"));
%>

</body>
</html>
