<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error_page.jsp" %>

<html>
<head>
    <title>Main</title>
</head>
<body>
<li>
    <ul>
        <form action="/taskservlet/developers" method="get">
            Enter developer's grade:
            <input type="text" name="grade"/>
            <input type="submit" value="Get dev list">
        </form>
    </ul>
    <ul>
        <form action="/taskservlet/developers" method="get">
            Enter developer's skill:
            <input type="text" name="skill"/>
            <input type="submit" value="Get dev list"/>
        </form>
    </ul>
    <ul>
        <form action="/taskservlet/developers" method="get">
            Enter project name:
            <input type="text" name="projectname"/>
            <input type="submit" value="Get dev list"/>
        </form>
    </ul>
    <br/>
    <ul>
        <form action="/taskservlet/projects" method="get">
            Enter project name:
            <input type="text" name="projectdevssalarysum"/>
            <input type="submit" value="Get sum salary"/>
        </form>
    </ul>
    <ul>
        <button>
            <a href="projects">Get all projects info</a>
        </button>
    </ul>

</li>
</br>
</br>
CRUD Operations
<li>
    <ul>
        <form action="/taskservlet/developers" method="get">
            Enter developer id:
            <input type="text" name="id"/>
            <input type="submit" value="Get developer info"/>
        </form>
    </ul>
    <ul>
        <form action="/taskservlet/developers" method="post">
            Enter developer`s data:
            <input type="text" name="name"/>
            <input type="text" name="sex"/>
            <input type="text" name="salary"/>
            <input type="submit" value="Add developer"/>
        </form>
    </ul>
    <ul>
        <form action="/taskservlet/developers" method="put">
            Enter developer`s id and then data for change:
            <input type="text" name="id"/>
            <input type="text" name="name"/>
            <input type="text" name="sex"/>
            <input type="text" name="salary"/>
            <input type="submit" value="Update developer"/>
        </form>
    </ul>
    <ul>
        <form action="/taskservlet/developers" method="delete">
            Enter developer`s id to delete:
            <input type="text" name="id"/>
            <input type="submit" value="Delete developer"/>
        </form>
    </ul>
<ul>
    <button><a href="developers">Get all developers</a></button>
</ul>
</li>
</body>
</html>
