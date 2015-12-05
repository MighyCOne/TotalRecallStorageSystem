<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<%@ page errorPage="ErrorOccurred.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Used Javascript with DynaValidatorForm and DispatchAction to be able to set the name of the buttons to something other than the method name -->

<script language="javascript" type="text/javascript">
	function submitForm(para) {
		if (para == 1) {
			document.forms[0].action = "m_actions.do?manaOpers=viewCustomerTransaction";
		}
		if (para == 2) {
			document.forms[0].action = "m_actions.do?manaOpers=viewAllCustomerBalances";
		}
		if (para == 3) {
			document.forms[0].action = "m_actions.do?manaOpers=viewAllManagers";
		}
		if (para == 4) {
			document.forms[0].action = "m_actions.do?manaOpers=addNewStorageUnit";
		}
		if (para == 5) {
			document.forms[0].action = "m_actions.do?manaOpers=dailyUpdate";
		}

		document.forms[0].submit();
	}
</script>

<!--Bootstrap  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!--CSS: my_style.css-->
<link type="text/css" rel="stylesheet" href="my_style.css" />


<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

</head>
<body>
	<!-- Possible boostrap navbar implementation. Tricky to do with Struts. -->
	<%-- <nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> Welcome, Manager <bean:write
					name="manager_name" /></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Page 1</a></li>
				<li><html:form action="logout_action">
				<input type="submit" value="Logout" class="btn btn-default" style="background-color:#000000;color:#ffffff"/>
			</html:form></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
						<li><html:form action="logout_action">
								<html:submit value="Logout">Logout</html:submit>
							</html:form></li>
					</ul></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li>
				<li></li>
			</ul>
		</div>
	</div>
	</nav>
 --%>
	<%
		//This caching code prevents someone who has gone to another page(like logging out) from returning using back.
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>

	<!-- Add this back in -->

	,
	<table>


		<tr>
			<html:form action="/m_actions">
				<td><html:submit onclick="submitForm(1)">View Customer Transactions</html:submit>
				</td>
				<td><html:submit onclick="submitForm(2)">View Customer Balances"</html:submit>
				</td>
				<td><html:submit onclick="submitForm(3)">View Managers"</html:submit>
				</td>
				<td><html:submit onclick="submitForm(4)">Add New Storage Unit"</html:submit>
				</td>
				<td><html:submit onclick="submitForm(5)">Daily Update"</html:submit>
				</td>

			</html:form>

			<td>
				<!--to AddNewCustomer.jsp then action--> <html:link
					href="AddNewCustomer.jsp">
					<html:submit value="Add New Customer"></html:submit>
				</html:link>
			</td>
		</tr>
		<tr>
			<td>
				<!--to AddNewCustomer.jsp then action--> <!--AssignUnitToCustomer.jsp  -->
				<html:link href="AssignUnitToCustomer.jsp">
					<html:submit value="Assign Unit to Customer"></html:submit>
				</html:link>
			</td>

			<td><html:link href="ViewUnits.jsp">
					<html:submit value="View Units"></html:submit>
				</html:link></td>
			<td><html:link href="AddNewManager.jsp">
					<html:submit value="Add New Manager"></html:submit>
				</html:link></td>
			<td><html:link href="DeleteSomeone.jsp">
					<html:submit value="Delete Manager/Customer"></html:submit>
				</html:link></td>
			<td><html:link href="DeleteUnit.jsp">
					<html:submit value="Delete Unit"></html:submit>
				</html:link></td>
			<td><html:link href="DeleteTransaction.jsp">
					<html:submit value="Delete Transaction"></html:submit>
				</html:link></td>
			<td><html:form action="logout_action">
					<html:submit value="Logout"></html:submit>
				</html:form></td>
		</tr>



	</table>


	<!-- Alternative way using action tags -->
	<!-- <!-- to AddNewCustomer.jsp then action
<form action="AddNewCustomer.jsp">
	<input type="submit" value="Add New Customer"></input>
</form>

AssignUnitToCustomer.jsp 
<form action="AssignUnitToCustomer.jsp">
	<input type="submit" value="AssignUnitToCustomer"></input>
</form> -->


	<br>
</body>
</html>