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

<title>Add Project</title>
</head>
<body>

	<!-- Add Project -->
	<div data-role="page" id="addProject">
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

			
				String sql = "select fname,lname from resource";
				String sql2 = "select clientname from clients";
				
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
			<form method="post" action="ProjectController "
				style="width: 20%; margin: 0 auto; width: 100%; text-align: left">
				<h3>Add Project</h3>
					<div>
					<table>
						<tr>
							<td><label for="client">Client:</label></td>
							<td><select name="client" id="client"
								 data-native-menu="false">
									<option>Client</option>
									<%
										try {
											Class.forName(driverName);
											con = DriverManager.getConnection(url, user, password);
											ps = con.prepareStatement(sql2);
											rs = ps.executeQuery();
											while (rs.next()) {
												String clientName = rs.getString("clientname");
									%>
									<option value=<%=clientName%>><%=clientName%></option>
									<%
										}
										} catch (SQLException sqe) {
											out.println("home" + sqe);
										}
									%>
							</select></td>
							<td>&nbsp;&nbsp;</td>
							<td><label for="pname">Project Name:</label></td>
							<td><input type="text" name="projectName" id="projectName" required></td>
							
						</tr>

						<tr>
							<td><label for="pcode">Project Code:</label></td>
							<td><input type="text" name="projectCode" id="projectCode"></td>
							<td>&nbsp;&nbsp;</td>
							<td><label for="dateStart">Date Start:</label></td>
							<td><input type="date" name="dateStart" id="dateStart" ></td>
						</tr>

						<tr>
							<td><label for="dateEnd">Date End:</label></td>
							<td><input type="date" name="dateEnd" id="dateEnd" ></td>
							<td>&nbsp;&nbsp;</td>
							
							<script>
							
$("#dateEnd").change(function () {
    var startDate = document.getElementById("dateStart").value;
    var endDate = document.getElementById("dateEnd").value;
 
    if ((Date.parse(endDate) <= Date.parse(startDate))) {
        alert("End date should be greater than Start date");
        document.getElementById("dateEnd").value = "";
    }
});
</script>				
							<td><label for="notes">Notes:</label></td>
							<td><textarea rows="4" cols="50" name="notes" id="notes"></textarea></td>
						</tr>

						<tr>
							<td><label for="budget" >Budget:</label></td>
							<td><input placeholder="Please enter number here..." type="text" name="budget" id="budget" oninput="this.value = this.value.replace(/[^0-9.]/g, ''); this.value = this.value.replace(/(\..*)\./g, '$1')" required></td>
							<td>&nbsp;&nbsp;</td>
							<td><label for="team">Team:</label></td>
					
							<td><select name="team" id="team"
								multiple="multiple" data-native-menu="false" required>
									<option>Resources</option>
									<%
										try {
											//Class.forName(driverName);
											//con = DriverManager.getConnection(url, user, password);
											ps = con.prepareStatement(sql);
											rs = ps.executeQuery();
											while (rs.next()) {
												String resourceName = rs.getString("fname");
									%>
									<option value=<%=resourceName%>><%=resourceName%></option>
									<%
										}
										} catch (SQLException sqe) {
											out.println("home" + sqe);
										}
									%>
							</select></td>
						</tr>
						<tr>
							<td><label for="select-native-1">Invoice Method:</label></td>
							<td><select name="invoiceMethod" id="select-native-1">
									<option value="Billable">Billable</option>
									<option value="Non Billable">Non Billable</option>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Add" /></td>

						</tr>

					</table>
					</div>					
					
			</form>
		</div>
<div id="error"></div>

	</div>
</body>
</html>