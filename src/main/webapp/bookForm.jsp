<%--
  Created by IntelliJ IDEA.
  User: mattd
  Date: 3/22/2023
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
// A form that takes a new books title, isbn, edition number, and copyright, and sends a post request to the servlet
<form action="http://localhost:8080/BookStore/BookServlet" method="post">
    <label for="title">Title</label>
    <input type="text" name="title" id="title">
    <label for="isbn">ISBN</label>
    <input type="text" name="isbn" id="isbn">
    <label for="edition">Edition</label>
    <input type="text" name="edition" id="edition">
    <label for="copyright">Copyright</label>
    <input type="text" name="copyright" id="copyright">
    <input type="submit" value="Submit">
</form>
</body>
</html>
