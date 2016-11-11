<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>

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
<title>Manage</title>
</head>
<body>

	<!-- Manage -->
	<div data-role="page" id="manage">
<% 
				DatabaseOperations dao=new DatabaseOperations();
				List<Resource> resources = new Resource();
				List<Client> clients = new Client();
				
				resources=dao.getAllResource();
				clients=dao.getAllClients();
							
				int size1=resources.size();
				int size2=clients.size();
				int size3=4;
				int size4=5;
				%>
				
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
				
				

		<div data-role="main" class="ui-content" id="welcomepage" 
		style="background-image: url(css/themes/images/tierone.png);
		background-repeat: no-repeat;
		background-size: 100% 100%;">
		
				<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background:#40bf80">	
					<h3>Summary</h3>
					</div>
					<div class="ui-body ui-body-a">	
						<a href="2resources.jsp"><button>Resources -<%=size1 %></button></a><br>
						<a href="2clients.jsp"><button>Clients -<%=size2 %></button></a><br>
						<a href="2categories.jsp"><button>Categories -<%=size4 %></button></a><br>
						</div>
					
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				
	</div>
	</div>
	</div>

</body>
</html>