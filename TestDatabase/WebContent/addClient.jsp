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
	<div data-role="page" id="addClient">
<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			<div style="float:right">
			<a>Welcome Home, <%=session.getAttribute("name")%>!</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="logout.jsp">Log Out</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="1help.jsp">Help</a>&nbsp;
			</div>
		</div>
			
				
				
					<div id="maintab" class="ui-bar ui-bar-a">
					<p style="text-align:center; font-size: 20px;font-family: 'Comfortaa', cursive;">Financial
				Reporting Tool</p>
				<div data-role="navbar" id="tabs">
				<ul>
						<li><a href="1home.jsp" data-icon="home" class="ui-corner-all">Home</a></li>
						<li><a href="1import.jsp" data-icon="info" class="ui-corner-all">Import Timesheets</a></li>
						<li ><a href="1project.jsp" data-icon="bullets" class="ui-corner-all">Projects</a></li>
						<li ><a href="1report.jsp" data-icon="action" class="ui-corner-all">Reports</a></li>
						<li ><a href="1manage.jsp"data-icon="user" class="ui-corner-all">Manage</a></li>
						
						</ul>
					</div>
				
				<div style=background:navy"></div>
				<div data-role="navbar" id="secondmaintab">
				<ul>
					<li><a href="2resources.jsp" class="ui-corner-all" >Resources</a></li>
					<li><a href="2clients.jsp" class="ui-corner-all" >Clients</a></li>
					
						
				</ul>
				</div>	
				</div>
					
		<div data-role="main" class="ui-content" style="background-color:light-white">		
			<form method="post" action="ClientController " name="formClient"
				style="width: 20%; margin: 0 auto; width: 100%; text-align: left">
				<h3>Add Client</h3>
				<div>
					<table>
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