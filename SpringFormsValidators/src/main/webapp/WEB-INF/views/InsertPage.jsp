<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<html>
<head>
</head>
<body>
<hr>
<h2>Enter Employee Details </h2>
<hr>
<pre>
	<frm:form action="AddEmp" modelAttribute="emp">

				Employee number : <frm:input path="eno"/>		<frm:errors path="eno"/>
				Employee name   : <frm:input path="ename"/>		<frm:errors path="ename"/>
				Employee salary : <frm:input path="sal"/>		<frm:errors path="sal"/>
				
				<input type="submit" value="Add Employee">
	</frm:form>
</pre>
</body>
</html>