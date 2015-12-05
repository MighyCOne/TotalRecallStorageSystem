<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@include file="ManagerPortal.jsp"%>
 <html:errors/>
 <br><br>
Please Insert the Following Fields:
<br><br>
<!--Goes to AddNewCustomerAction.java  -->
<html:form action="/addnewmana">
<table>
	<tr><td>Manager Name: <html:text property="name"></html:text></td></tr>
	<tr><td>Manager Email: <html:text property="email"></html:text></td></tr>
	<tr><td>Manager Username:<html:text property="username"></html:text></td></tr>
	<tr><td>Manager Password:<html:text property="password"></html:text></td></tr>
	<tr><td><html:submit value="Add Customer"></html:submit></td></tr>
</table>
</html:form>
</body>
</html>