<%@page import="java.sql.*" %>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mybookstore","root","root");
	String sql="SELECT distinct subject from books";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
%>
<html>
<body>
	<form action="BookListServlet" method="post">
		
<%
	while(rs.next()){
		String s1=rs.getString(1);	
%>
	 <input type="checkbox" name="subjects" value="<%=s1%>"/><%=s1%><br>	
<% } %>		
				
				<input type="submit" value="Get-List"/>
	
	</form>
</body>
</html>