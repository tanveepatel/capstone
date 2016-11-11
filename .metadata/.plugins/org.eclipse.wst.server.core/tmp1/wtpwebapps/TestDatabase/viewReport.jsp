 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- For google chart only -->
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
 <link rel="stylesheet" type="text/css" href="css/style3.css"> 	  
<title>View Report</title>
</head>
<body>


	<!-- View Report -->
	<div data-role="page" id="viewReport">
<% 
				DatabaseOperations dao=new DatabaseOperations();
				List<Project> projects = new Project();
				projects=dao.getAllProjects();			
				int size1=projects.size();
			
				ResultSet res=(ResultSet)request.getAttribute("result");
				
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
				</div>	
		<div data-role="main" class="ui-content" style="background-color:light-white">
			<div id="table_div"></div>
			<table cellspacing="20">
			<tr>
			<td>Project Code</td>
			<td>Project Name</td>
			<td>Hours</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Project Budget</td>
			<td>Resource Name</td>
			<td>Bill Rate</td>
			</tr>
			
			<%
			while (res.next())
			{
			%>
			<tr>
			<td><%=res.getString("project") %></td>
		
			<td><%=res.getString("hours") %></td>
			</tr>
			<% 
			}
			%>
		
			<tr>
			<td><% %></td>
			<td><% %></td>
			<td><% %></td>
			<td><% %></td>
			<td><% %></td>
			<td><% %></td>
			</tr>
			
			</table>
		</div>
		
		<h1><%=request.getParameter("fname")%></h1>
<%System.out.print(request.getParameter("fname"));%>
	<div data-role="footer">
			<div class="ui-corner-all custom-corners">
					<div class="ui-bar ui-bar-a" style="background:lightgreen">				
					</div>
			</div>
	</div>	
	</div>
</body>

      

	}
</script>
</html>