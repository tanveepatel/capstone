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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- For google chart only -->
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
 <link rel="stylesheet" type="text/css" href="css/style3.css">
<title>Project Summary Report</title>
</head>
<body>
<div data-role="page" id="projectreport" style="background-color: white;">

<% 
				DatabaseOperations dao=new DatabaseOperations();
				List<Project> projects = new Project();
				projects=dao.getAllProjects();			
				int size1=projects.size();
			
				ResultSet res=(ResultSet)request.getAttribute("result");
				//ResultSet res1=(ResultSet)request.getAttribute("total");
				
				%>
			<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			<div style="float:right">
			<a>Welcome Home, <%=session.getAttribute("name")%>!</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="logout.jsp">LogOut</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="1help.jsp">Help</a>&nbsp;
			</div>
		</div>
			
				
				<div id="maintab" class="ui-bar ui-bar-a">
				<h3 style="font-size: 20px;text-align:center; margin-bottom:10px;font-family: 'Comfortaa', cursive;display:block">Financial Reporting Tool</h3>
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
			<div id="table_div"></div>
			<h3 align="center" style="font-size:20px ;font-family:'Comfortaa',cursive;" >Project Summary Report </h3>
			<!-- <table width="300" cellpadding="10" style="text-align: center" align="center">
			<tr bgcolor=#40bf80 border="1" style="font-weight:bold"> -->
			<table class="hoverTable">
			<tr>
			<td>Project Name</td>
			<td>Project Code</td>
			<td>Purchase Order#</td>
			<td>Project Start Date</td>
			<td>Project Budget</td>
			<td>Consultant Name</td>
			<td>Hours Per Day</td>
			<td>Consultant Cost Rate</td>
			</tr>
			<% double total=0; %>
			<%
			while (res.next())
			{
			%>
			<tr>
			<td><%=res.getString("project") %></td>
			<td><%=res.getString("code") %></td>
			<td><%=res.getString("invoice") %></td>
			<td><%=res.getString("sdate") %></td>
			<% double x = Double.parseDouble(res.getString("budget"));
			total += x; %>
			<td>$<%=x%></td>
			<td><%=res.getString("fname") %></td>
			<td><%=res.getString("hours") %></td>
			<td><%=res.getString("costRate") %></td>
			<%-- <td><%=res.getString("fund") %></td> --%>
			</tr>
			<% 
			}

			%>
			</table>
			<br>
			<table align="right" bgcolor=#0080ff style="font-weight:bold; color:white;" cellpadding="10">
			<td style="border:2px solid black;">TOTAL PROJECT BUDGET = <%=total %>0$</td>
			</table>
			
		
		</div>
		
		
	</div>
</body>
</html>