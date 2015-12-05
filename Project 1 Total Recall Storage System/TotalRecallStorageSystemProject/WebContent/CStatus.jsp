<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="StatusToggle.jsp" %>
<br>

Your status has been updated to <font color="blue"><b><%=session.getAttribute("current_status") %></b></font>

<br><center><font color="green"><h3>Success! Buying Status Updated!</h3></font></center>
</body>
</html>