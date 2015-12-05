<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
</head>
<body>
<%@ include file="CustomerPortal.jsp" %>
<br>
<html:errors/>
Input feedback:
<br>
<html:form action="/feed_back">
	<html:textarea property="feedback"></html:textarea><br>
	<html:submit value="Submit Feedback"></html:submit>
</html:form>
</body>
</html>