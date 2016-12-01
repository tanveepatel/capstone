<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Home</title>
</head>
<body>

	<!-- Home -->
	<div data-role="page" id="home" style="background-color: white;">
		<% 
				DatabaseOperations dao=new DatabaseOperations();
				
				int resources=dao.getNumResourc();
				int projects=dao.getNumProject();
				int clients=dao.getNumClient();
				
				%>
		<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" style="" />
			<div style="float: right">

				<a>Welcome Home, <%=session.getAttribute("name")%>!
				</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="logout.jsp">Log Out</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="1help.jsp">Help</a>&nbsp;
			</div>
		</div>


		<div id="maintab" class="ui-bar ui-bar-a">

			
				<h3 style="font-size: 20px;text-align:center; margin-bottom:10px;font-family: 'Comfortaa', cursive;display:block">Financial Reporting Tool</h3>
			<div data-role="navbar" id="tabs">
				<ul>
					<li><a href="1home.jsp" data-icon="home" class="ui-corner-all" rel="external">Home</a></li>
					<li><a href="1import.jsp" data-icon="info"
						class="ui-corner-all">Import Timesheets</a></li>
					<li><a href="1project.jsp" data-icon="bullets"
						class="ui-corner-all">Projects</a></li>


					<li>
						<div class="dropdown">
							<button data-icon="action" class="ui-corner-all"
								style="background: #2164d1; color: white; width: 269px;">Reports</button>
							<div class="dropdown-content"
								style="position: fixed; background: #2164d1; color: white; width: 269px;">
								<a href="projectSummaryReport.jsp" rel="external">Project Summary Report</a> <a
									href="resourceHours.jsp" rel="external">Resource Analysation Report</a> <a
									href="billRateDepartment.jsp" rel="external">Bill Rate For Department </a>
							</div>
						</div>
					</li>
					<li>
						<div class="dropdown">
							<button data-icon="user" class="ui-corner-all"
								style="background: #2164d1; color: white; width: 269px;">Manage</button>
							<div class="dropdown-content"
								style="position: fixed; background: #2164d1; color: white; width: 267px;">
								<a href="2resources.jsp">Resources</a> <a href="2clients.jsp">Clients</a>
							</div>
						</div>
					</li>

				</ul>

			</div>
		</div>

<div style="height:40px"></div>

			<h4 id="subwelcome" style="margin:20px;font-size:20px;font-family: 'Comfortaa', cursive">Here's How to Get Started:</h4>
			<div id="dashboard" style="float:left;margin:20px">
				<div class="ui-corner-all custom-corners" style="width: 230px;">
					<div class="ui-bar ui-bar-a" style="background: #40bf80">
						<h3>
							Total Projects:&nbsp;<%=projects%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addProject.jsp"><button>Add New Projects</button></a>
					</div>

				</div>
				<br>
				<div class="ui-corner-all custom-corners" style="width: 230px;">
					<div class="ui-bar ui-bar-a" style="background: #40bf80">
						<h3>
							Total Employees:&nbsp;<%=resources %></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addPerson.jsp"><button>Add New Resources</button></a>
					</div>

				</div>
				<br>
				<div class="ui-corner-all custom-corners" style="width: 230px;">
					<div class="ui-bar ui-bar-a" style="background: #40bf80">
						<h3>
							Total Client:&nbsp;<%=clients %></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addClient.jsp"><button>Add New Clients</button></a>
					</div>

				</div>
				<br>


				<div class="ui-corner-all custom-corners" style="width: 230px;">
					<div class="ui-bar ui-bar-a" style="background: #40bf80">
						<h3>
							Total Budget:
							<%=dao.getTotalBudget()%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="1report.jsp"><button>Get Reports</button></a>
					</div>
				</div>

			</div>

		<!-- background-image: url(css/themes/images/tierone.png); -->
		<div data-role="main" class="ui-content" id="welcomepage"
			style="background-repeat: no-repeat; background-size: 100% 100%;">
			<table >
			<tr>
			<td>
			<div id="my_chart"
				style="background-color: none; width: 600px; height: 500px;"></div>
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<%
				JSONArray data = dao.generateJSON();
				pageContext.setAttribute("data", data);
			%>
</td>
<td>

<div id="my_chart1"
				style="background-color: none; width: 600px; height: 500px; "></div>
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<%
				JSONArray data1 = dao.generateResourceJSON();
				pageContext.setAttribute("data1", data1);
			%>
			</td>
			</tr>
			</table>
			
<script>
			
   google.load("visualization", "1", {packages:["corechart"]});
   google.setOnLoadCallback(drawChart);
   google.setOnLoadCallback(drawChart1);
   
   function drawChart() {
    // Create and populate the data table.
    var data = google.visualization.arrayToDataTable(${data});
    var options = {
      title: 'Hours Per Project',
      is3D: true,
      backgroundColor: { fill: "white" }
    };
     // Create and draw the visualization.
    new google.visualization.PieChart(
      document.getElementById('my_chart')).draw(data, options);
  }

   function drawChart1() {
	    // Create and populate the data table.
	    var data = google.visualization.arrayToDataTable(${data1});
	    
	    var options = {
	      title: 'Hours Per Resource',
	      is3D: true,
	      backgroundColor: { fill: "white" }
	    };
	     // Create and draw the visualization.
	    new google.visualization.PieChart(
	      document.getElementById('my_chart1')).draw(data, options);
	  }

</script>
	</div>

	</div>

</body>
</html>


