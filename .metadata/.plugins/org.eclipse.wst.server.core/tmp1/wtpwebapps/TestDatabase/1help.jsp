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

<title>Help</title>
</head>
<body>

	<!-- Help -->
	<div data-role="page" id="help">
		<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			<div style="float:right">
			<a style=color:blue>Welcome Home, <%=session.getAttribute("name")%>!</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="logout.jsp">Log Out</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="1help.jsp">Help</a>&nbsp;
			</div>
		</div>
			
				
				
					<div class="ui-bar ui-bar-a" style="background:lightgreen">
					<h3 class="mainheading"
				style="font-size: 20px;font-family: 'Comfortaa', cursive;">Financial
				Reporting Tool</h3><br>
				<div data-role="navbar">
				<ul>
						<li><a href="1home.jsp" data-icon="search" class="ui-corner-all">Home</a></li>
						<li><a href="1import.jsp" data-icon="search" class="ui-corner-all">Import Timesheets</a></li>
						<li><a href="1project.jsp" data-icon="search" class="ui-corner-all">Projects</a></li>
						<li><a href="1report.jsp" data-icon="search" class="ui-corner-all">Reports</a></li>
						<li><a href="1manage.jsp" data-icon="search" class="ui-corner-all">Manage</a></li>
						
						</ul>
					</div>
				</div>
							
		<div data-role="main" class="ui-content" style="background-color:#ebf6f9">
		<div class="ui-corner-all custom-corners">
					<div class="ui-bar ui-bar-a" style="background:lightgreen">
						<h3>Documentation:</h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="1help.jsp">About Home Page</a><br><br>
						<a href="1help.jsp">How to Import csv file</a><br><br>
						<a href="1help.jsp">How to add Projects</a><br><br>
						<a href="1help.jsp">How to generate Reports</a><br><br>
						<a href="1help.jsp">How to add Clients</a><br><br>
						<a href="1help.jsp">How to add Resources/Employee</a><br><br>
						<a href="1help.jsp">How to add Task and Catagories</a><br><br>
					</div>
					
				</div>
			</div>
		

		<div data-role="footer">
			<div class="ui-corner-all custom-corners">
					<div class="ui-bar ui-bar-a" style="background:lightgreen">
						
						</div>
		</div>
	</div>
	</div>
</body>
</html>