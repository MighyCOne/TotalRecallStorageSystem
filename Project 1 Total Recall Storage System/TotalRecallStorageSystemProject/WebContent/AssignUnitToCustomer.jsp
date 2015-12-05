<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="ManagerPortal.jsp"%>

<html:errors/>

Assign a Unit to Customer:
<br><br>

	<html:form action="/m_aucPath">
		Customer Id:<html:text property="custId"></html:text><br>
		Storage Unit Id:<html:text property="storageId"></html:text><br>
		<html:submit value="Submit"></html:submit>
	</html:form>	
	
	<%@include file="DisplayCustormerOrAvailableUnits.jsp" %>
</body>
</html>