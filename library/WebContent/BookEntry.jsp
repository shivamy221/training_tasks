<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Entry</title>
</head>
<body>
	<h1>Book Entry</h1>
	<hr>
		<form method="post" action="BookEntry">
			Book Name : <input type="text" name="bname" > <br>
			Author	  : <input type="text" name="author"> <br>
			Book Code : <input type="text" name="bcode"><br>
			Subject   : <input type="text" name="bsub"><br>
			<br>
			<input type="submit" value="Add Book"/><br>
			<br>
			<a href="index.jsp">Go back</a>
	
		</form>
	<hr>
</body>
</html>