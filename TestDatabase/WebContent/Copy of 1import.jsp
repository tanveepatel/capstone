
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/mobile/git/jquery.mobile-git.css">
<script src="//code.jquery.com/jquery-1.10.1.js"></script>
<script src="jquery.mobile.nestedlists.js"></script>
<style>
#edit-with-js-bin {
	display: none !important;
}
</style>

<title>Import</title>


</head>
<body>
	<!-- Import -->
	<div data-role="page" id="import">
		<%
			DatabaseOperations dao = new DatabaseOperations();
			List<FileData> filedata = new FileData();
			filedata = dao.getAllFileData();
			List<Project> projects = new Project();
			projects = dao.getAllProjects();
			List<Client> clients = new Client();
			clients = dao.getAllClients();
			int size1 = clients.size();
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
					<li><a href="1home.jsp" data-icon="search"
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
			style="background-color: #ebf6f9">
			<!-- #d8ecf3,#c4e3ed to try -->

			<form method="post" action="UploadController"
				enctype="multipart/form-data" data-ajax="false" style="width: 300px">
				Select .csv timesheet to upload: <input type="file" name="uploadFile" /> <input
					data-ajax="false" type="submit" value="Upload" />
			</form>
			<br>
			<table style="width: 50%; margin: auto; left: 50%;" class="table">
				<%
					for (int i = 0; i < size1; i++) {
				%>
				<tr>

					<th class="info"><b><%=((Client) clients.get(i)).getClientName()%></b></th>
				</tr>
				
				<%
					String name = clients.get(i).getClientName();
						List<Project> clientProjects = dao.getAllClientProjects(name);
						System.out.println(name);
						for (int j = 0; j < clientProjects.size(); j++) {
							String team = ((Project) clientProjects.get(j)).getTeam();
							List<String> teamList = Arrays.asList(team.split(", "));
							String projectName = clientProjects.get(j).getProjectName();
							pageContext.setAttribute("projectName", projectName);
							double projectSum = dao.getSumProjectHours(projectName);
							pageContext.setAttribute("projectSum", projectSum);
							
				%>
				<tr>
				

					<td>
						<div data-role="collapsible">
							<h1>${projectName}<span class="ui-li-count">Total hours: ${projectSum}</h1>
							<h4>Project Resources:</h4>
							<%
							
								for (int k = 0; k < teamList.size(); k++) {
									String resourceName = teamList.get(k);
									
									
										double sum = dao.getSumHours(resourceName, projectName);
										pageContext.setAttribute("sum", sum);
										pageContext.setAttribute("resourceName", resourceName);
															
									
							%>
							
							<div data-role="collapsible">
								<h4>${resourceName}<span class="ui-li-count">Total hours: ${sum}</span>
								</h4>
								<h4>Time Logged:</h4>
								<table style="width:100%">
									<tr>
										<th>Date</th>
										<th>Hours</th>
									</tr>
								</table>
								<%			
									for (int l = 0; l < filedata.size(); l++) {
													String fname = filedata.get(l).getFname();
													String projectname = filedata.get(l).getProject();
													String timeRecord;
													String hours;

													if (fname.equals(teamList.get(k))
															&& clientProjects.get(j).getProjectName().equals(projectname)) {
														timeRecord = filedata.get(l).getDate();
														hours = filedata.get(l).getHoure();
														pageContext.setAttribute("timeRecord", timeRecord);
														pageContext.setAttribute("hours", hours);
								%>
								
								${timeRecord} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								${hours} <br>

								<%
									}
								
									}			
								%>
								
							</div>
							<%						
								}
											
								%>

						</div></td>
				</tr>
				<%
									
						}
						
					}
				%>

			</table>
		</div>
		<div data-role="footer">
			<div class="ui-corner-all custom-corners">
				<div class="ui-bar ui-bar-a" style="background: lightgreen"></div>
			</div>
		</div>
</body>
</html>



