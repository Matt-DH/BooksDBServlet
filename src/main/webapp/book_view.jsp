<%@ page import="java.util.List" %>
<%@ page import="com.mattdh.booksdbservlet.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: mattd
  Date: 3/24/2023
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Book dump!

<!-- book list attribute is available --->

<% List<Book> bookList =  (List<Book>) request.getAttribute("bookList"); %>

<table>
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Edition</th>
        <th>Copyright</th>
    </tr>

    <%
        for (Book book: bookList) {
            out.println("<tr>");
            out.println("<td>" + book.getIsbn() + "</td>");
            out.println("<td>" + book.getTitle() + "</td>");
            out.println("<td>" + book.getEditionNumber() + "</td>");
            out.println("<td>" + book.getCopyright() + "</td>");
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>