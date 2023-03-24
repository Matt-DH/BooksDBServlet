<%--
  Created by IntelliJ IDEA.
  User: mattd
  Date: 3/23/2023
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mattdh.booksdbservlet.Book" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<Book> bookList =  (List<Book>) request.getAttribute("booklist"); %>
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
</body>
</html>
