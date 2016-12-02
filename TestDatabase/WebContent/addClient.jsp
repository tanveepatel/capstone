<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style3.css">
<title>Add Client</title>
</head>
<body>

	<!-- Add Client -->
	<div data-role="page" id="addClient" style="background-color: white;">
<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			<div style="float:right">
			<a>Welcome Home, <%=session.getAttribute("name")%>!</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="logout.jsp">Log Out</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="1help.jsp">Help</a>&nbsp;
			</div>
		</div>
			
				
				
					<div id="maintab" class="ui-bar ui-bar-a">
					<h3 style="font-size: 20px;text-align:center; margin-bottom:10px;font-family: 'Comfortaa', cursive;display:block">Financial Reporting Tool</h3>
				<div data-role="navbar" id="tabs">
				<ul>
						<li><a href="1home.jsp" rel="external"" data-icon="home" class="ui-corner-all">Home</a></li>
						<li><a href="1import.jsp" data-icon="info" class="ui-corner-all">Import Timesheets</a></li>
						<li ><a href="1project.jsp" data-icon="bullets" class="ui-corner-all">Projects</a></li>
						
						
						<li>
						<div class="dropdown">
							<button data-icon="action" class="ui-corner-all"
								style="background: #2164d1; color: white; width: 269px;">Reports</button>
							<div class="dropdown-content"
								style="position: fixed; background: #2164d1; color: white; width: 269px;">
								<a href="projectSummaryReport.jsp" rel="external">Project Summary Report</a>
								 <a href="resourceHours.jsp" rel="external">Budget Analysis</a> <a href="billRateDepartment.jsp" rel="external">Bill Rate For Department </a>
							</div>
						</div>
					</li>
						<li>
						<div class="dropdown">
							<button data-icon="user" class="ui-corner-all"
								style="background: #2164d1; color: white; width: 269px;">Manage</button>
							<div class="dropdown-content"
								style="position: fixed; background: #2164d1; color: white; width: 267px;">
								<a href="2resources.jsp">Resources</a> 
								<a href="2clients.jsp">Clients</a> 
							</div>
						</div>
					</li>
						
						</ul>
						
					</div>
				</div>
					
		<div data-role="main" class="ui-content" style="background-color:light-white">		
			<form method="post" action="ClientController " name="formClient"
				style="width: 20%; margin: 0 auto; width: 100%; text-align: left">
				<h3 style="margin-left:550px">Add Client</h3>
				<div>
					<table style="margin-top:20px;background-color:#40bf80;border-radius:15px;padding:20px;margin-left:450px">
					<tr>
						<td><label for="cname">Name:</label></td> 
						<td><input type="text" name="name" id="name" required></td>
					</tr>
					<tr>
						<td><label for="address">Address:</label></td>
						<td><input type="text" name="address" id="address"></td>
					</tr>
					<tr>
					<td><label for="select-native-1">Currency:</label></td> 
					<td><select name="currency" id="select-native-1" required>
					<option value="cad">CAD</option>
					<option value="usd">USD</option>
					<option value="gdp">GDP</option>
					<option value="eur">EUR</option>
					</select></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Add"/></td>
					</tr>
		 	</table>
			</div>					
					
			</form>
			</div>
	
	</div>
</body>
</html>