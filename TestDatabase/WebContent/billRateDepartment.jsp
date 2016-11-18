<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>
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
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<script type="text/javascript" src="https://www.google.com/jsapi"></script>


<title>Report</title>
</head>
<body>

	<!-- Report -->
	<div data-role="page" id="report">
		<%
			DatabaseOperations dao=new DatabaseOperations();
				List<Project> projects = new Project();
				projects=dao.getAllProjects();
							
				int size1=projects.size();
				
				Connection con = null;

				PreparedStatement ps,ps2 = null;
				

				ResultSet rs,rs2 = null;

				String driverName = "com.mysql.jdbc.Driver";

				String url = "jdbc:mysql://localhost:3306/capstone";

				String user = "root";

				String password = "$@rita201091";

				String sql = "select name from project";
				String sql2 = "select fname from resource";
		%>

		<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			<div style="float: right">
				<a>Welcome Home, <%=session.getAttribute("name")%>!
				</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="logout.jsp">LogOut</a>&nbsp;&nbsp;|&nbsp;&nbsp;
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
						
						
						<li>
						<div class="dropdown">
							<button data-icon="action" class="ui-corner-all"
								style="background: #2164d1; color: white; width: 269px;">Reports</button>
							<div class="dropdown-content"
								style="position: fixed; background: #2164d1; color: white; width: 269px;">
								<a href="projectSummaryReport.jsp">Project Summary Report</a> <a href="resourceHours.jsp">Resource
									Analysation Report</a> <a href="billRateDepartment.jsp">Bill Rate For Department </a>
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

		<div data-role="main" class="ui-content"
			style="background-color: none">
			<div id="my_chart2"
				style="background-color: none; width: 600px; height: 400px; position: absolute; float: left; top: 50%;"></div>
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<%
				JSONArray data2 = dao.generateDeptAvgRateJSON();
					pageContext.setAttribute("data2", data2);
			%>

			<script>
   google.load("visualization", "1", {packages:["corechart"]});
   google.setOnLoadCallback(drawChart);
 
	   function drawChart() {
		    // Create and populate the data table.
		    var data2 = google.visualization.arrayToDataTable(${data2});
		    var options2 = {
		      title: 'Average Bill Rate by Department',
		      is3D: true,
		      backgroundColor: { fill: "#f9f9f9" }
		  
		    };
		     // Create and draw the visualization.
		    new google.visualization.BarChart(
		      document.getElementById('my_chart2')).draw(data2, options2);
		  }
   
   
</script>
		</div>

	</div>



</body>
</html>