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
   <%@include file="ManagerPortal.jsp"%>
   <html:errors/>
<br><br>
Please Insert the Following Fields:
<br><br>
<!--Goes to AddNewCustomerAction.java  -->
<html:form action="/addnewcust">
	Customer Name: <html:text property="name"></html:text><br>
	Customer Email: <html:text property="email"></html:text><br>
	Customer Username:<html:text property="username"></html:text><br>
	Customer Password:<html:text property="password"></html:text><br>
		
	<html:submit value="Add Customer"></html:submit>
</html:form>

</body>
</html>