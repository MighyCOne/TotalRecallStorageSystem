<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<logic:present name="dsForm">
	<%@include file="DeleteSomeone.jsp" %>
</logic:present>

<logic:present name="duForm">
	<%@include file="DeleteUnit.jsp" %>
</logic:present>

<logic:present name="dtForm">
	<%@include file="DeleteTransaction.jsp" %>
</logic:present>


<br>
<center><h3><font color="red">Delete failed. </font></h3></center>

</body>
</html>