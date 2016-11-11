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
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style3.css">

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			
<title>Home</title>
</head>
<body>

	<!-- Home -->
	<div data-role="page" id="home">
<% 
				DatabaseOperations dao=new DatabaseOperations();
				
				int resources=dao.getNumResourc();
				int projects=dao.getNumProject();
				int clients=dao.getNumClient();
				
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
					
		<div data-role="main" class="ui-content" id="welcomepage" 
		style="background-image: url(css/themes/images/tierone.png);
		background-repeat: no-repeat;
		background-size: 100% 100%;">
		<div id="my_chart"
				style="background-color: none;width: 550px; height: 350px; position: absolute; top: 30%; left: 32%; left:750px;"></div>
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<%
				JSONArray data = dao.generateJSON();
				pageContext.setAttribute("data", data);
			%>
			<script>
   google.load("visualization", "1", {packages:["corechart"]});
   google.setOnLoadCallback(drawChart);
   function drawChart() {
    // Create and populate the data table.
    var data = google.visualization.arrayToDataTable(${data});
    var options = {
      title: 'Hours Per Project'
    };
     // Create and draw the visualization.
    new google.visualization.PieChart(
      document.getElementById('my_chart')).draw(data, options);
  }
</script>
		
			<h3 id="subwelcome">Here's how to get started:</h3>
			<div id="dashboard">
				<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background:#40bf80">
						<h3>Total Projects:&nbsp;<%=projects%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addProject.jsp"><button> Add New Projects</button></a>
					</div>
					
				</div>
				<br>
				<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background:#40bf80">
						<h3>Total Employees:&nbsp;<%=resources %></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addPerson.jsp"><button> Add New Employees</button></a>
					</div>
					
				</div>
				<br>
				<div class="ui-corner-all custom-corners" style="width: 300px;" >
					<div class="ui-bar ui-bar-a" style="background:#40bf80">
						<h3>Total Client:&nbsp;<%=clients %></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addClient.jsp"><button> Add New Clients</button></a>
					</div>
					
				</div>
				<br>
				
					
					<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background: #40bf80">
						<h3>Total Budget: <%=dao.getTotalBudget()%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="1report.jsp"><button>Get Reports</button></a>
					</div>	
				</div>
					
				</div>
			</div>
			
		</div>


	</div>

</body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

<script type="text/javascript" src="https://www.google.com/jsapi"></script>


<title>Home</title>
</head>
<body>

	<!-- Home -->
	<div data-role="page" id="home">
		<%
			DatabaseOperations dao = new DatabaseOperations();

			int resources = dao.getNumResourc();
			int projects = dao.getNumProject();
			int clients = dao.getNumClient();
		%>
		<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			<div style="float: right">
				<a style="color: blue">Welcome Home, <%=session.getAttribute("name")%>!
				</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="logout.jsp">LogOut</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="1help.jsp">Help</a>&nbsp;
			</div>
		</div>



		<div class="ui-bar ui-bar-a" style="background: lightgreen">
			<p
				style="text-align: center; font-size: 20px; font-family: 'Comfortaa', cursive;">Financial
				Reporting Tool</p>
			<div data-role="navbar">
				<ul>
					<li><a href="loginForm.jsp" data-icon="search"
						class="ui-corner-all">Home</a></li>
					<li><a href="1import.jsp" data-icon="search"
						class="ui-corner-all">Import Timesheets</a></li>
					<li><a href="1project.jsp" data-icon="search"
						class="ui-corner-all">Projects</a></li>
					<li><a href="1report.jsp" data-icon="search"
						class="ui-corner-all">Reports</a></li>
					<li><a href="1manage.jsp" data-icon="search"
						class="ui-corner-all">Manage</a></li>

				</ul>
			</div>
		</div>

		<div data-role="main" class="ui-content" id="welcomepage"
			style="background-image: url(css/themes/images/tierone.png); background-repeat: no-repeat; background-size: 100% 100%;">
			<div id="my_chart"
				style="width: 600px; height: 400px; position: absolute; top: 40%; left: 32%;"></div>
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<%
				JSONArray data = dao.generateJSON();
				pageContext.setAttribute("data", data);
			%>
			<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			<script>
   google.load("visualization", "1", {packages:["corechart"]});
   google.setOnLoadCallback(drawChart);
   function drawChart() {
    // Create and populate the data table.
    var data = google.visualization.arrayToDataTable(${data});
    var options = {
      title: 'Hours Per Project'
    };
     // Create and draw the visualization.
    new google.visualization.PieChart(
      document.getElementById('my_chart')).draw(data, options);
  }
</script>

			<h3 id="subwelcome">Here's how to get started:</h3>
			<div id="dashboard">
				<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background: lightgreen">
						<h3>
							Total Projects:&nbsp;<%=projects%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addProject.jsp"><button>Add New Projects</button></a>
					</div>
				</div>
				<br>
				<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background: lightgreen">
						<h3>
							Total Employees:&nbsp;<%=resources%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addPerson.jsp"><button>Add New Employees</button></a>
					</div>

				</div>
				<br>
				<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background: lightgreen">
						<h3>
							Total Clients:&nbsp;<%=clients%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="addClient.jsp"><button>Add New Clients</button></a>
					</div>

				</div>
				<br>
				<div class="ui-corner-all custom-corners" style="width: 300px;">
					<div class="ui-bar ui-bar-a" style="background: lightgreen">
						<h3>Total Budget: <%=dao.getTotalBudget()%></h3>
					</div>
					<div class="ui-body ui-body-a">
						<a href="1report.jsp"><button>Get Reports</button></a>
					</div>	
				</div>
			</div>
		</div>


		<div data-role="footer">
			<div class="ui-corner-all custom-corners">
				<div class="ui-bar ui-bar-a" style="background: lightgreen"
					style="float:center"></div>
			</div>
		</div>
	</div>
</body>
</html>
 --%>