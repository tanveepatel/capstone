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
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style3.css">

<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<title>Edit Project</title>

</head>
<body>

	<!-- Add Project -->
	<div data-role="page" id="editProject" style="background-color: white;">
		<% String pname = request.getParameter("pname");
		DatabaseOperations dao=new DatabaseOperations();
		Project project = new Project();
		project=dao.getProject(pname);
		System.out.println("from editproject "+pname);
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
						<li><a href="1home.jsp" data-icon="home" class="ui-corner-all" rel="external">Home</a></li>
						<li><a href="1import.jsp" data-icon="info" class="ui-corner-all">Import Timesheets</a></li>
						<li ><a href="1project.jsp" data-icon="bullets" class="ui-corner-all">Projects</a></li>
						
						
						<li>
						<div class="dropdown">
							<button data-icon="action" class="ui-corner-all"
								style="background: #2164d1; color: white; width: 269px;">Reports</button>
							<div class="dropdown-content"
								style="position: fixed; background: #2164d1; color: white; width: 269px;">
								<a href="projectSummaryReport.jsp" rel="external">Project Summary Report</a>
								 <a href="resourceHours.jsp" rel="external">Budget Analysis</a>
									 <a href="billRateDepartment.jsp" rel="external">Bill Rate For Department </a>
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
			<form method="post" action="editProjectController" style="width: 20%; margin: 0 auto; width: 100%; text-align: left" style="width: 20%; margin: 0 auto; width: 100%; text-align: left">
			<h3>Edit Project</h3>
					<div>
					<table>
						<tr>
						<td><label for="client">Client:</label> </td>
						<td><input type="text" name="client" id="client" value="<%=project.getClient()%>"></td>
						<td>&nbsp;&nbsp;</td>
						<td><label for="pname">Project Name:</label> </td>
						<td><input type="text" name="projectName" id="projectName" value="<%=project.getProjectName()%>"></td>
						</tr>
						
						<tr>
						<td><label for="pcode">Project Code:</label> </td>
						<td><input type="text" name="projectCode" id="projectCode" value="<%=project.getProjectCode()%>"></td>
						<td>&nbsp;&nbsp;</td>
						<td><label for="dateStart">Date Start:</label> </td>
						<td><input type="date" name="dateStart" id="dateStart" value="<%=project.getDateStart()%>"></td>
						</tr>
						
						<tr>
						<td><label for="dateEnd">Date End:</label> </td>
						<td><input type="date" name="dateEnd" id="dateEnd" value="<%=project.getDateEnd()%>"></td>
						<td>&nbsp;&nbsp;</td>
						<td><label for="notes">Notes:</label></td>
						<td><input type="text" name="notes" id="notes" value="<%=project.getNotes()%>"></td>
						</tr>
						
						<tr>
						<td><label for="budget">Budget:</label></td>
						<td><input type="text" name="budget" id="budget" value="<%=project.getBudget()%>"></td>
						<td>&nbsp;&nbsp;</td>
						<td><label for="team">Team:</label></td>
						<td><input type="text" name="team" id="team" value="<%=project.getTeam()%>"></td>
						</tr>
				
						<tr>
						<td><label for="select-native-1">Invoice Method:</label> </td>
						<td><select
							name="invoiceMethod" id="select-native-1">
							<option value="Billable">Billable</option>
							<option value="Non Billable">Non Billable</option>
						</select></td>
						<td>&nbsp;&nbsp;</td>
						
						<tr>
						<td></td>
						<td><input type="submit" value="Edit"/></td>
						
						
						</tr>
						
					</table>
					</div>					
					
			</form>
		</div>


</body>

</html>