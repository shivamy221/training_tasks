<%@page import="java.sql.ResultSet"%>
<%
ServletContext contex = this.getServletContext();
String driver = contex.getInitParameter("driver");
String url = contex.getInitParameter("url");
String dbUsername = contex.getInitParameter("dbusername");
String dbPassword = contex.getInitParameter("dbpassword");

Class.forName(driver);
java.sql.Connection con=java.sql.DriverManager.getConnection(url,dbUsername,dbPassword);

String user = (String)session.getAttribute("user");
String sql="SELECT password,username,address,mobile,email from users where userid=?";
java.sql.PreparedStatement ps=con.prepareStatement(sql);
ps.setString(1,user);
java.sql.ResultSet rs=ps.executeQuery();

while(rs.next()){
%>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h3>Online Book Store</h3>
	<h4>Update-Details</h4>
	<hr>
	<form action="ProfileUpdate">
	<pre>
		Password	<input type="password" name="password" value="<%=rs.getString(1) %>"/>
		Username	<input type="text" name="username" value="<%=rs.getString(2) %>"/>
		Address		<input type="text" name="address" value="<%=rs.getString(3) %>"/>
		Mobile		<input type="text" name="mobile" value="<%=rs.getString(4) %>"/>
		Email-Id	<input type="text" name="email" value="<%=rs.getString(5) %>"/>
				<input type="submit" value="Update-Profile"/>
				
<%  } //end of while
	
	con.close();%>
	</pre>
	</form>
	<hr>
</body>
</html>