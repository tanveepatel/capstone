<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Resource" %>
<%@ page import="model.FileData" %>
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
<title>Add Resource</title>
</head>
<body>

	<!-- Add Resource -->
<div data-role="page" id="addProject">

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
					<li><a href="2categories.jsp" class="ui-corner-all">Categories</a></li>
						
				</ul>
				</div>	
				</div>
					
		<div data-role="main" class="ui-content" style="background-color:light-white">		
			<form method="post" action="PersonController "
				style="width: 20%; margin: 0 auto; width: 100%; text-align: left">
				<h3>Add Resource</h3>
					<div>
					<table>
					<tr>
					<td><label for="fname">First name:</label></td>
					<td><input type="text" name="fname" id="fname"></td>
					<td>&nbsp;&nbsp;</td>
					<td><label for="lname">Last name:</label> </td>
					<td><input type="text" name="lname" id="lname"></td>
					</tr>
					
					<tr>
					<td><label for="brate">Billable Rate:</label> </td>
					<td><input type="text" name="brate" id="brate"></td>
					<td>&nbsp;&nbsp;</td>
					<td><label for="crate">Cost Rate:</label></td>
					<td><input type="text" name="crate" id="crate"></td>
					</tr>
					
					<tr>
					<td><label for="select-native-1">Permissions:</label></td>
					<td><select
						name="permissions" id="select-native-1">
						<option value="Regular User">Regular User</option>
						<option value="Project Manager">Project Manager</option>
						<option value="Administrator">Administrator</option>
					</select></td>
					<td>&nbsp;&nbsp;</td>
					<td><label for="select-native-1">Department:</label>  </td>
					<td><select name="department" id="select-native-1">
						<option value="Professional Services" >Professional Services</option>
						<option value="Product Development" >Product Development</option>
						<option value="Product Management" >Product Management</option>
						<option value="Consulting" >Consulting</option>
					</select></td>
					</tr>
					
					
					<tr>
					<td><label for="email">Email:</label></td>
					<td><input type="email" name="email" id="email"></td>
					<td>&nbsp;&nbsp;</td>
					<td> </td>
					<td></td>
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