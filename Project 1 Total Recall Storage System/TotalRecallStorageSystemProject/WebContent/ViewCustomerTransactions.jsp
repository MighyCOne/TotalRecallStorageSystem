<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.eintern.orm.entity.Transaction"%>
     <%@ page import="com.eintern.orm.entity.Customer"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="ManagerPortal.jsp"%>
<br>

<!-- <h3>View Customer Transactions:</h3> -->
	<center>
		<table border="1">
		<tr>  
		<th colspan="7">View Customer Transactions</th>
		</tr>
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Transaction Id</th>
				<th>Latest Transaction</th>
				<th>Transaction Date</th>
				<th>Storage Id</th>
				<th>Time until payment due (in days)</th>
			</tr>
			<%
				for (Transaction trans : (List<Transaction>) session.getAttribute("all_transactions")) {
			%>

			<tr>
				<td><%=trans.getCustomer().getCustId()%></td>
				<td><%=trans.getCustomer().getCustName()%></td>
				<td><%=trans.getTransactionId()%></td>
				<td>$<%=trans.getDollarAmount()%></td>
				<td><%=trans.getDateEntered()%></td>
				<td><%=trans.getStorageunit().getUnitId()%></td>
				<td><%=trans.getStorageunit().getTimeRemaining()%></td>
			</tr>
			<%
				}
			%>
		</table>


</body>
</html>