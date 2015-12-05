<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.eintern.orm.entity.Manager"%>
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
		<th colspan="4">Manager Directory</th>
		</tr>
			<tr>
				<th>Manager Id</th>
				<th>Name</th>
				<th>Email</th>
				
			</tr>
			<%
				for (Manager manager : (List<Manager>) session.getAttribute("all_managers")) {
			%>

			<tr>
				<td><%=manager.getManaId()%></td>
				<td><%=manager.getManaName()%></td>
				<td>$<%=manager.getManaEmail()%></td>
			
			</tr>
			<%
				}
			%>
		</table>
		</center>


</body>
</html>