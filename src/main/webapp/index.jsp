<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<br/>
<a href="book_add.jsp">Add a book</a>
<a href="author_add.jsp">Add an author</a>
<a href="library-data?view=book_view">View all books</a>
<a href="library-data?view=author_view">View all authors</a>
</body>
</html>