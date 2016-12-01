
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style3.css">

<title>Import</title>


    
</head>
<body>
<!-- Import -->
		<div data-role="page" id="import" style="background-color: white;">
<% 
				DatabaseOperations dao=new DatabaseOperations();
				List<FileData> filedata = new FileData();
				filedata=dao.getAllFileData();
							
				//int size1=filedata.size();
				
				List<Client> clients = new Client();
				clients = dao.getAllClients();
				int size1 = clients.size();
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
								<a href="projectSummaryReport.jsp" rel="external">Project Summary Report</a> <a href="resourceHours.jsp" rel="external">Resource
									Analysation Report</a> <a href="billRateDepartment.jsp" rel="external">Bill Rate For Department </a>
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
				
		
	<div data-role="main" class="ui-content" id="welcomepage" 
		style="background-color:white">
			<!-- #d8ecf3,#c4e3ed to try -->
		
		
		<form method="post" action="UploadController" enctype="multipart/form-data" data-ajax="false" style="width: 600px" accept=".csv">
		<table>
		<tr>
			<td> <h4>Select File to Upload:</h4> </td><td> <input type="file" name="uploadFile" /> </td>
			<td><input data-ajax="false" type="submit" value="Upload"/></td>
			</tr>
			</table>
		</form>
			
      	
      	 <form class="ui-filterable" style="width: 44.3%;">
  <input id="myFilter" data-type="search" placeholder="Search by Client Name or Project name">
</form>
      	<br>
			<table id= "myTable" data-input="#myFilter" data-filter="true" style="width: 100%; margin: auto; left: 50%; background-color:#40bf80;border-radius:15px" class="table">
				<%
					for (int i = 0; i < size1; i++) {
				%>
				<tr style= "font-size:20px;" >

					<th class="info"><b><%=((Client)clients.get(i)).getClientName()%></b></th>
				</tr>
				
				
				<%
					String name = clients.get(i).getClientName();
						List<Project> clientProjects = dao.getAllClientProjects(name);
						System.out.println(name);
						for (int j = 0; j < clientProjects.size(); j++) {
							String team = ((Project) clientProjects.get(j)).getTeam();
							List<String> teamList = Arrays.asList(team.split(", "));
							System.out.println(team);
							String projectName = clientProjects.get(j).getProjectName();
							pageContext.setAttribute("projectName", projectName);
							double projectSum = dao.getSumProjectHours(projectName);
							pageContext.setAttribute("projectSum", projectSum);
							
				%>
			
				<tr>
				

					<td>
						<div data-role="collapsible">
							<h1>${projectName}<span class="ui-li-count">Total hours: ${projectSum}</h1>
						
							<%
							System.out.println("running from import.jsp");
							
								for (int k = 0; k < teamList.size(); k++) {
									String resourceName = teamList.get(k);
									
									
										double sum = dao.getSumHours(resourceName, projectName);
										pageContext.setAttribute("sum", sum);
										pageContext.setAttribute("resourceName", resourceName);
															
									
							%>
							
							<div style="background-color:#f2f2f2; border-radius:10px;padding-left:10px">
								<h4>${resourceName}<span>  - Total hours: ${sum}</span>
								</h4>
								<b>Time Logged:</b></br>
								
										Date &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										Hours</br>
								
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
								
								${timeRecord} &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
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
		
</body>
</html>



 