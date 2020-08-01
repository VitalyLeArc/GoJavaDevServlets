<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</body>
</html>
