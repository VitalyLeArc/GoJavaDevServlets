<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>developers</title>
</head>
<body>
<%@include file="header_back.jsp" %>
<table>
    <tr>
        <th>developers name</th>
    </tr>
    <c:forEach var="developer" items="${requestScope.developers}">
        <tr>
            <td><c:out value="${developer.name}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
