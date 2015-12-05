<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VFMLogin</title>

<!-- Put your custom css style AFTER Bootstrap or your custom css style settings will be overriden -->
<!--Bootstrap  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!--CSS: my_style.css-->
<link type="text/css" rel="stylesheet" href="my_style.css" />

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
	
<script src="https://code.jquery.com/jquery-2.1.4.min.js">

</script>
<script type="text/javascript">
$(function() {
    $("#usern").attr("placeholder", "Username");
});
$(function() {
    $("#passw").attr("placeholder", "Password");
});
</script>

</head>
<body>
	<div class="container">

		<div class="try3">
			<h3>Total Recall Storage Management Application</h3>
			<br>
			<h4>Login:</h4>
			<!--  Submit and Button can be used for the same thing, but Button passes a value along with it-->
			<html:form action="login1">
				
				<html:text styleClass="form-control" property="username" styleId="usern"></html:text>
				<br>
				<html:password styleClass="form-control" property="password" styleId="passw"></html:password>
				<html:radio property="type" value="customer" >Customer</html:radio>
				<html:radio property="type" value="manager" >Manager</html:radio>
				<br>
				<html:submit styleClass="form-control btn-primary" value="Login"></html:submit>

			</html:form>
			
			<html:errors/>

			
		</div>
	</div>

	<div id="footer">
		<div class="box">
			<h2>This web application was created by Coran Coley.</h2>
		</div>
	</div>

	</div>

</body>
</html>