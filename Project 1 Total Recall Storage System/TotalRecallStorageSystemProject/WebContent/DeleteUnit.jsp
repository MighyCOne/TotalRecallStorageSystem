<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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
Input Unit Id:<br>
<table>

<html:form action="/delete_unit"> 
	<tr><td>Unit Id:<html:text property="id"></html:text><td><tr>
	<tr><td><html:submit value="Delete"></html:submit></td></tr>
	
</html:form>
</table>

</body>
</html>