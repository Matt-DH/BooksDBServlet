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
<form action="test_post" method="post">
    <jsp:include page="library-data">
        <jsp:param name="view" value="test_post"/>
    </jsp:include>
    <input type="submit" value="submit">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="bookForm.jsp">Book Form Page</a>
</body>
</html>