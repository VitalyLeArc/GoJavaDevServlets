<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error_page.jsp" %>

<html>
<head>
    <title>salarysum</title>
</head>
<body>
<%@include file="header_back.jsp" %>
<br/>
sum salary = <%
    out.println((BigDecimal) request.getAttribute("projectdevssalarysum"));
%>

</body>
</html>
