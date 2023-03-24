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
    <title>Add a book</title>
</head>
<body>
<h1 name="view" value="bookAdd"></h1>
<h1>Add a book</h1>
<form action="titles_add" method="post">
    <input type="hidden" name="view" value="book_add">
    <label for="authorID">Author ID:</label><br>
    <input type="text" id="authorID" name="titlesAuthorID"><br>
    <label for="isbn">ISBN:</label><br>
    <input type="text" id="isbn" name="titlesIsbn"><br>
    <label for="title">Title:</label><br>
    <input type="text" id="title" name="titlesTitle"><br>
    <label for="editionNum">Edition Number:</label><br>
    <input type="text" id="editionNum" name="titlesEditionNum"><br>
    <label for="copyright">Copyright:</label><br>
    <input type="text" id="copyright" name="titlesCopyright"><br>
    <input type="submit" id="submit" value="SUBMIT">
</form>
</body>
</html>
