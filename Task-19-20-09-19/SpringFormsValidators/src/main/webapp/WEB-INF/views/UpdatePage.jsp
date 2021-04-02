<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<html>
<head>
<title>Update Employee</title>
</head>
<body>
<hr>
<h1 align="center">Update Employee</h1>
<hr>
<pre>
	<frm:form action="updateEmp" >
		<p align="center">
			Enter Details of Employee whose data you want to update
			
			Employee id    = <frm:input path="eno"/>	<frm:errors path="eno"/>
			Employee name  = <frm:input path="ename"/>	<frm:errors path="ename"/>
			Employee salary= <frm:input path="sal"/>	<frm:errors path="sal"/>
			
							<input type="submit" value="Update">			
		</p>
	</frm:form>
</pre>
</body>
</html>