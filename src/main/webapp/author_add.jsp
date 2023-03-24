<%--
  Created by IntelliJ IDEA.
  User: mattd
  Date: 3/23/2023
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 name="view" value="authorAdd"></h1>
<h1>Add an author</h1>
<form action="authors_add" method="post">
    <input type="hidden" name="view" value="author_add">
    <label for="authorID">Author ID:</label><br>
    <input type="text" id="authorID" name="authorsAuthorID"><br>
    <label for="firstName">First Name:</label><br>
    <input type="text" id="firstName" name="authorsFirstName"><br>
    <label for="lastName">Last Name:</label><br>
    <input type="text" id="lastName" name="authorsLastName"><br>
    <input type="submit" id="submit" value="SUBMIT">
</form>
</body>
</html>
