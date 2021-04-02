<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
<form method="get" action="SearchBook">
	Book Subject : <select name="subject">
					<option>computer</option>
					<option>Literature</option>
					<option>Fiction</option>
			</select>
			<input type="submit" value="Subject"/>
			<hr>
			<a href="BookEntry.jsp">Add Book</a>
</form>
<hr>
</body>
</html>