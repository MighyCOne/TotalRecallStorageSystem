<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="CustomerPortal.jsp" %>
<br></br>
Your current <font color="blue">Ready to Buy </font> status is set to: <font color="blue"><b><%=session.getAttribute("buying?") %></b></font>


<html:form action="/c_toggle">
		
Change Status?<html:submit value="Toggle Buy Status"></html:submit>
	</html:form>

</body>
</html>