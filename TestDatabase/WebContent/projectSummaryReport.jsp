<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>
<%@ page import="java.sql.*"%>
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
<title>Project Summary Report</title>
</head>
<body>
	<!-- Project Summary Report -->
	<div data-role="page" id="projectSummaryReport">
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

				String password = "root";

				String sql = "select name from project";
				String sql2 = "select fname from resource";
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
				<form method="post" action="ProjectReportController" style="width: 20%; margin: 0 auto; width: 100%; text-align: left">
				<table>
				<tr>
			
						<td><label for="projectName">Project Name:</label> </td>
						<td><select name="name">
						<option>Select all Project</option>
						<%
							try {
								Class.forName(driverName);
								con = DriverManager.getConnection(url, user, password);
								ps = con.prepareStatement(sql);
								rs = ps.executeQuery();
								while (rs.next())
									{
								String projectName = rs.getString("name");
						%>
						<option><%=projectName%></option>
						<%
								}}
								catch (SQLException sqe)
								{out.println("home" + sqe);}
						%>
						</select>
						<td>&nbsp;&nbsp;</td>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="View Report"/></td>
					</tr>
				
				
				</table>
				</form>
			</div>
	
	
	</div>

</body>
</html>