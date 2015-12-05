<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page errorPage="ErrorOccurred.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!--Bootstrap  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!--CSS: my_style.css-->
<link type="text/css" rel="stylesheet" href="my_style.css" />

<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

</head>
<body>

	<%
		//This caching code prevents someone who has gone to another page(like logging out) from returning using back.
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	Welcome
	<%=session.getAttribute("customer_name")%>,
	<br>
	<br>
	<table>
		<tr>
			<td><html:link href="MakePayment.jsp">
					<html:submit value="Make Payment"></html:submit>
				</html:link></td>
			<td><html:link href="Feedback.jsp">
					<html:submit value="Feedback"></html:submit>
				</html:link></td>

			<td><html:form action="/c_viewMU">
					<html:submit value="View My Units"></html:submit>
				</html:form></td>

			<td><html:form action="/view_balance">
					<html:submit value="View My Balance"></html:submit>
				</html:form></td>
			<td><html:form action="/c_toggle0">
					<html:submit value="View/Set Buyer Status"></html:submit>
				</html:form></td>
			<td><html:form action="logout_action">
					<html:submit value="Logout"></html:submit>
				</html:form></td>
		</tr>
	</table>
</body>
</html>