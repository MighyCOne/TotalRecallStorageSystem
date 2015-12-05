<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.eintern.orm.entity.StorageUnit"%>
         <%@ page import="com.eintern.orm.entity.Transaction"%>
          <%@ page import="com.eintern.orm.entity.Customer"%>
    <%@ page import="java.util.Set"%>
       <%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="ViewUnits.jsp"%>
<br>
<!-- <h3>View Assigned Storage Units:</h3> -->
	<center>
		<table border="1">
		<tr>  
		<th colspan="5">View Assigned Storage Units</th>
		</tr>
			<tr>
				<th>Unit Id</th>
				<th>Available?</th>
				<th>Time Remaining (days)</th>
				<th>Customer Id</th>
				<th>Customer Name</th>
			</tr>
			<%
				for (StorageUnit unit : (List<StorageUnit>) session.getAttribute("assigned_units")) {
			%>

			<tr>
				<td><%=unit.getUnitId()%></td>
				<td><%=unit.isAvailable()%></td>
				<td><%=unit.getTimeRemaining() %></td>
				
				<%
				for (Transaction trans : (Set<Transaction>)unit.getTransaction() ) {
				Customer customer=trans.getCustomer();
			%>
				
				<td><%=customer.getCustId() %></td>
				<td><%=customer.getCustName() %></td>
					<%
				}
			%>
				
			</tr>
			<%
				}
			%>
		</table>
</center>
</body>
</html>