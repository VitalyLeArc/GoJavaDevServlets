<%@ page import="domain.Project" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error_page.jsp" %>

<html>
<head>
    <title>projects</title>
</head>
<body>
<%@include file="header_back.jsp"%>
<table>
    <tr>
        <th>Дата Создания</th>
        <th>Название проекта</th>
        <th>Кол-во разработчиков</th>
    </tr>
    <%
        List<Project> projects = (List<Project>) request.getAttribute("projects");
        for (Project proj : projects) {
            out.println("<tr>\n" +
                    "<td>" + proj.getDate() + "</td>\n" +
                    "<td>" + proj.getName() + "</td>\n" +
                    "<td>" + proj.getDevelopers().size() + "</td>\n" +
                    "</tr>");
        }
    %>
</table>

</body>
</html>
