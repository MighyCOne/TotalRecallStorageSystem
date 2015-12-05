<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.eintern.orm.entity.StorageUnit"%>
      <%@ page import="com.eintern.orm.entity.Transaction"%>
<%@ page import="java.util.Set"%>
<%@include file="CustomerPortal.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <h3>View My Units:</h3> -->
	<center>
		<table border="1">
		<tr>  
		<th colspan="5">View My Units</th>
		</tr>
			<tr>
				<th>Unit Id</th>
				<th>Payment Due (in days)</th>
			</tr>
			<%
				for (Transaction transaction : (Set<Transaction>) session.getAttribute("tset")) {
			%>

			<tr>
				<td><%=transaction.getStorageunit().getUnitId()%></td>
				<td><%=transaction.getStorageunit().getTimeRemaining()%></td>
			</tr>
			<%
				}
			%>
		</table>
		</center>
</body>
</html>