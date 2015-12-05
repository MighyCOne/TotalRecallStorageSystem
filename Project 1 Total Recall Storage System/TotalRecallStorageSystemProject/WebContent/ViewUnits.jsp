<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript">
	function submitForm(para) {
		if (para == 1) {
			document.forms[0].action = "m_units.do?view=viewAllUnits";
		}
		if (para == 2) {
			document.forms[0].action = "m_units.do?view=viewAssignedUnits";
		}
		if (para == 3) {
			document.forms[0].action = "m_units.do?view=viewAvailableUnits";
		}
		document.forms[0].submit();
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="ManagerPortal.jsp"%>
	<!--  SEVERE PROBLEM ON THIS PAGE: Using an include makes it so the parameter set in struts-config.xml
	 cant be found. Probably because I'm using an include on a page with Javascript while retrieve a page with javascript.-->
	<html:form action="/m_units">
		<table>
			<tr>				
				<td> <html:submit property="view" value="viewAllUnits" />
					</td>

				<td><html:submit property="view" value="viewAssignedUnits" />
					</td>

				<td><html:submit property="view" value="viewAvailableUnits" />

			</tr>
		</table>
	</html:form>
</body>
</html>

