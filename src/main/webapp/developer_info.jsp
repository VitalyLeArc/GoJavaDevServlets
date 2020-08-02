<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error_page.jsp" %>

<html>
<head>
    <title>developer</title>
</head>
<br>
<%@include file="header_back.jsp" %>
Selected Developer Info
</br>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Sex</th>
    </tr>
    <tr>
        <c:set var="developer" scope="request" value="${requestScope.developers}"/>
        <td><c:out value="${developer.id}"/> </td>
        <td><c:out value="${developer.name}"/> </td>
        <td><c:out value="${developer.salary}"/> </td>
        <td><c:out value="${developer.sex}"/> </td>
    </tr>
</table>
</br>
Has skills
<li>
    <c:forEach var="skill" items="${requestScope.developers.skills}">
        <ul><c:out value="${skill.name}"/>  <c:out value="${skill.grade}"/></ul></c:forEach>
</li>
</body>
</html>
