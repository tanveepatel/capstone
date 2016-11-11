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
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style3.css">

<title>Report</title>


</head>
<body>

	<!-- Report -->
	<div data-role="page" id="report">
		<% 
				DatabaseOperations dao=new DatabaseOperations();
				List<Project> projects = new Project();
				projects=dao.getAllProjects();
				
				List<Client> c = new Client ();
				c=dao.getAllClients();
			
int size1=projects.size();
				
				Connection con = null;

				PreparedStatement ps,ps2 = null;
				

				ResultSet rs,rs2 = null;

				String driverName = "com.mysql.jdbc.Driver";

				String url = "jdbc:mysql://localhost:3306/capstone";

				String user = "root";

				String password = "root";
				//String sql = "select name from project where client='"+clientName+"'";
				String sql = "select name from project";
				String sql2 = "select fname from resource";
				
				String sql3 = "select clientName from clients";
%>

		<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			<div style="float: right">
				<a>Welcome Home, <%=session.getAttribute("name")%>!
				</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="logout.jsp">Log Out</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="1help.jsp">Help</a>&nbsp;
			</div>
		</div>



		<div id="maintab" class="ui-bar ui-bar-a">
			<p
				style="text-align: center; font-size: 20px; font-family: 'Comfortaa', cursive;">Financial
				Reporting Tool</p>
			<div data-role="navbar" id="tabs">
				<ul>
					<li><a href="1home.jsp" data-icon="home" class="ui-corner-all">Home</a></li>
					<li><a href="1import.jsp" data-icon="info"
						class="ui-corner-all">Import Timesheets</a></li>
					<li><a href="1project.jsp" data-icon="bullets"
						class="ui-corner-all">Projects</a></li>
					<li><a href="1report.jsp" data-icon="action"
						class="ui-corner-all">Reports</a></li>
					<li><a href="1manage.jsp" data-icon="user"
						class="ui-corner-all">Manage</a></li>

				</ul>
			</div>
		</div>




		<div data-role="main" class="ui-content"
			style="background-color: light-white">
			<form method="post" action="ViewReportController"
				style="width: 20%; margin: 0 auto; width: 100%; text-align: left">
<!-- 				<table> -->
<!-- 				<tr> -->
<!-- 						<td> -->
						<%-- <label for="fname">Project Name:</label>
						<select name="projectName" id="projectName" multiple="multiple" data-native-menu="false" style="width:20px"> 
							
								<option>Select Project:</option>
								<%
										try {
											Class.forName(driverName);
											con = DriverManager.getConnection(url, user, password);
											ps = con.prepareStatement(sql);
											rs = ps.executeQuery();
											while (rs.next()) {
												String projectName = rs.getString("name");
									%>
								<option value=<%=projectName%>><%=projectName%></option>
								<%
										}
										} catch (SQLException sqe) {
											out.println("home" + sqe);
										}
									%>
						</select> --%>
						
						<!-- </td>
					</tr> -->



<table>
<tr>
						<td><label for="projectName">Project Name:</label> </td>
						<td><select name="projectName">
						<option value="select">Select a project</option>
						<%
							try {
								Class.forName(driverName);
								con = DriverManager.getConnection(url, user, password);
								//ps = con.prepareStatement(sql3);
								//rs = ps.executeQuery();
								//String clientName = rs.getString("clientName");
			 //System.out.println(clientName);
								//String sql5 = "select name from project";
								ps = con.prepareStatement(sql);
								rs = ps.executeQuery();
								
								while (rs.next())
									{
								String projectName = rs.getString("name");
								//long projectName=rs.getLong(3);
						%>
						<option value=<%=projectName%>><%=projectName%></option>
						<%
								}}
								catch (SQLException sqe)
								{out.println("home" + sqe);}
						%>
						</select>
				
						<td>&nbsp;&nbsp;</td>
						</td>
					</tr>


					<%-- <td><label for="fname">Resource Name:</label></td>
					<td><select name="fname">
							<option value="select">Select a Resource</option>
							<%
						try {
								Class.forName(driverName);
								con = DriverManager.getConnection(url, user, password);
								ps2 = con.prepareStatement(sql2);
								rs2=ps2.executeQuery();
								
								while (rs2.next())
									{
								String fname = rs2.getString("fname");
						%>
							<option value=<%=fname%>><%=fname%></option>
							<%
							}}
								catch (SQLException sqe)
								{out.println("home" + sqe);}
						%>
					</select></td>
					</tr> --%>

					<tr>
						<td><label for="dateFrom">Date From:</label></td>
						<td><input type="date" name="dateFrom" id="dateFrom"></td>
						<td>&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><label for="dateTo">Date To:</label></td>
						<td><input type="date" name="dateTo" id="dateTo"></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="View Report" /></td>
					</tr>

				</table>
			</form>
		</div>

	</div>
</body>
</html>