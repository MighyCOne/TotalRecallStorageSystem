<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="ManagerPortal.jsp" %>
<br>
<html:errors/><br>
Input Transaction Id:<br>
<table>

<html:form action="/delete_transaction"> 
	<tr><td>Transaction Id:<html:text property="id"></html:text><td><tr>
	<tr><td><html:submit value="Delete"></html:submit></td></tr>
	
</html:form>
</table>
</body>
</html>