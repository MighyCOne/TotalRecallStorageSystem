<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.eintern.orm.entity.Customer"%>
    <%@ page import="java.util.List"%>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<logic:present name="managerForm">
<%@include file="ManagerPortal.jsp"%>
</logic:present>

<logic:present name="sv2Form">
<%@include file="AssignUnitToCustomer.jsp"%>
</logic:present>



<br>

	<!-- <h3>View All Storage Units:</h3> -->
	<center>
		<table border="1">
		<tr>  
		<th colspan="6">View Available Storage Units</th>
		</tr>
			<tr>
				<th>Customer Id</th>
				<th>Name</th>
				<th>Balance Owed</th>
				<th>Email</th>
				<th>Feedback</th>
				<th>Ready to buy?</th>
			</tr>
			<%
				for (Customer customer : (List<Customer>) session.getAttribute("all_customers")) {
			%>

			<tr>
				<td><%=customer.getCustId()%></td>
				<td><%=customer.getCustName()%></td>
				<td>$<%=customer.getCustBalance()%></td>
				<td><%=customer.getCustEmail()%></td>
				<td><%=customer.getCustFeedback()%></td>
				<td><%=customer.isBuying_status()%></td>
			</tr>
			<%
				}
			%>
		</table>


</body>
</html>