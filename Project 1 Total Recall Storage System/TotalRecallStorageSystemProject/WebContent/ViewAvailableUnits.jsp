<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.eintern.orm.entity.StorageUnit"%>
    <%@ page import="java.util.List"%>
    <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<logic:present name="svForm">
<%@include file="AssignUnitToCustomer.jsp"%>
</logic:present>

<logic:present name="vuForm">
<%@include file="ViewUnits.jsp"%>
</logic:present>


<br>
<!-- <h3>View Available Units:</h3> -->
<center>
		<table border="1">
		<tr>  
		<th colspan="2">View Available Storage Units</th>
		</tr>
			<tr>
				<th>Unit Id</th>
				<th>Available?</th>
			</tr>
			<%
				for (StorageUnit unit : (List<StorageUnit>) session.getAttribute("available_units")) {
			%>

			<tr>
				<td><%=unit.getUnitId()%></td>
				<td><%=unit.isAvailable()%></td>
			</tr>
			<%
				}
			%>
		</table>
</center>
</body>
</html>