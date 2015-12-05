<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td><html:form action="/special_view">
	
		<html:submit property="va" value="viewAvailableUnits">View Available Units</html:submit>

	</html:form></td>
<td><html:form action="/special_view2">
	
		<html:submit property="va2" value="viewAllCustomerBalances">View Customer Balances</html:submit>

	</html:form></td></tr>


</table>
	
	
	

</body>
</html>