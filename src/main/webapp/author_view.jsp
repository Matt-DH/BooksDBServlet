<%@ page import="java.util.List" %>
<%@ page import="com.mattdh.booksdbservlet.Book" %>
<%@ page import="com.mattdh.booksdbservlet.Author" %>
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
Author dump!

<!-- book list attribute is available --->

<% List<Author> authorList =  (List<Author>) request.getAttribute("authorList"); %>

<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Books</th>
    </tr>

    <%
        for (Author author: authorList) {
            out.println("<tr>");
            out.println("<td>" + author.getAuthorID() + "</td>");
            out.println("<td>" + author.getFirstName() + "</td>");
            out.println("<td>" + author.getLastName() + "</td>");
            for (Book book : author.getBookList()) {
                out.println("<td>" + book.getIsbn() + " " + book.getTitle() + " " + book.getEditionNumber() + "</td>");
            }
            out.println("</tr>");
        }
    %>
</table>
</body>
</html>