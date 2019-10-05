<%@ page isELIgnored = "false" %>
<%-- <%@ page import=" java.util.List"%> 
<%@ page import="com.worldpay.model.EmpModel" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>All Employees</title>
</head>
<body>
<hr>
<h4>All Employee</h4>
<table>

<tr><th>Employee no.   </th><th>  Employee name  </th><th>  Salary   </th></tr>
	<c:forEach var="Emp" items="${EmpList}">
		<tr><td>${Emp.getEno()}</td>
		<td>${Emp.getEname()}</td>
		<td>${Emp.getSal()}</td>
		<td><a href="deleteEmp?eno=${Emp.getEno()}">Delete</a></td></tr>
	</c:forEach>

</table>
<hr>
<a href="index.jsp">Back Home</a>
<hr>
</body>
</html>