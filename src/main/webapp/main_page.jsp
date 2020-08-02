<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page errorPage="error_page.jsp" %>

<html>
<head>
    <title>Main</title>
</head>
<body>
<table>
    <tr><th width="200"></th><th width="150"></th><th width="100" align="center"></th></tr>
    <tr>
        <form action="/taskservlet/developers" method="get">
            <td width="200">Enter developer's grade:</td>
            <td width="100"><input type="text" placeholder="developer's grade" name="grade"/></td>
            <td width="100" align="center"><input type="submit" value="Get dev list"></td>
        </form>
    </tr>
    <tr>
        <form action="/taskservlet/developers" method="get">
            <td>Enter developer's skill:</td>
            <td><input type="text" placeholder="developer's skill" name="skill"/></td>
            <td align="center"><input type="submit" value="Get dev list"/></td>
        </form>
    </tr>
    <tr>
        <form action="/taskservlet/developers" method="get">
            <td>Enter project name:</td>
            <td><input type="text" placeholder="project name" name="projectname"/></td>
            <td align="center"><input type="submit" value="Get dev list"/></td>
        </form>
    </tr>
    <tr></tr>

    <tr>
        <form action="/taskservlet/projects" method="get">
            <td>Enter project name:</td>
            <td><input type="text" placeholder="project name" name="projectdevssalarysum"/></td>
            <td align="center"><input type="submit" value="Get sum salary"/></td>
        </form>
    </tr>
    <tr>
        <td><button>
            <a href="projects">Get all projects info</a>
        </button></td>
    </tr>

</table>
</br>
</br>
<h3>CRUD Operations</h3>
<table>
    <tr>
        <form action="/taskservlet/developers" method="get">
            <td width="200">Enter developer id:</td>
            <td width="30"><input type="text" placeholder="id" name="id"/>
            <td></td>
            <td></td>
            <td></td>
            <td width="70" align="center"><input type="submit" value="Get developer info"/>
        </form>
    </tr>
    <tr>
        <form action="/taskservlet/developers" method="post">
            <td width="200">Enter developer`s data:</td>
            <td width="30"></td>
            <td width="70"><input type="text" placeholder="name" name="name"/></td>
            <td width="70"> <input type="text" placeholder="male or female" name="sex"/></td>
            <td width="70"> <input type="text" placeholder="salary in $" name="salary"/></td>
            <td width="70"><input type="submit" value="Add developer"/></td>
        </form>
    </tr>
    <tr>
        <form action="/taskservlet/developers" method="post">
            <td>Enter developer`s id and then other data for change:</td>
            <td width="30"><input type="text" placeholder="id" name="idedit"/></td>
            <td><input type="text" placeholder="name" name="name"/></td>
            <td><input type="text" placeholder="male or female" name="sex"/></td>
            <td><input type="text" placeholder="salary in $" name="salary"/></td>
            <td><input type="submit" value="Update developer"/></td>
        </form>
    </tr>
    <tr>
        <form action="/taskservlet/developers" method="post">
            <td>Enter developer`s id to delete:</td>
            <td><input type="text" placeholder="id" name="iddelete"/></td>
            <td><input type="submit" value="Delete developer"/></td>
        </form>
    </tr>
<tr>
    <td><button><a href="developers">Get all developers</a></button></td>
</tr>
</table>
</body>
</html>
