
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


<title>Import</title>
<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  th = table.getElementsByTagName("th");
  for (i = 0; i < th.length; i++) {
    //td = tr[i].getElementsByTagName("td")[0];
    if (th) {
      if (th.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>

    
</head>
<body>
<!-- Import -->
		<div data-role="page" id="import">
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
		style="background-color:light-white">
			<!-- #d8ecf3,#c4e3ed to try -->
		
		<form method="post" action="UploadController" enctype="multipart/form-data" data-ajax="false" style="width: 300px" accept=".csv">
			Select file to upload: <input type="file" name="uploadFile" /> 
			<input data-ajax="false" type="submit" value="Upload"/>
		</form>
			
			<%-- 	<%
	    	for(int i=0; i < size1;i++)
	    	{
		    	%>
				<tr>
					<td>
						<b>
						<%= ((FileData)filedata.get(i)).getFname() %>
						</b>
					</td>
					<td>
						<b>
						<%= ((FileData)filedata.get(i)).getLname() %>
						</b>
					</td>		
					<td>
						<%= ((FileData)filedata.get(i)).getDate() %>
					</td>
					<td> 
						<%= ((FileData)filedata.get(i)).getProject()%>
					</td>
					<td>
						<%= ((FileData)filedata.get(i)).getHoure() %>
					</td>
					<td>
						<a href="editFileData.jsp?pname=<%=((FileData)filedata.get(i)).getFname()%>"><input type="button" value="Edit" style="width: 100px;"></a>
					</td>
					<td>
						<a href="deleteFileData.jsp?pname=<%=((FileData)filedata.get(i)).getFname()%>"><input type="button" value="Delete" style="width: 100px;"></a>
					</td>	
				
				<%
	      	}
      	%>
      	</table> --%>
      	
      	
      	 <input id="myInput" onkeyup="myFunction()" placeholder="Search For Customers...">
      	<br>
			<table id= "myTable" style="width: 100%; margin: auto; left: 50%;background-color:#40bf80;" class="table">
				<%
					for (int i = 0; i < size1; i++) {
				%>
				<tr style= "font-size:20px;" >

					<th data-filter="true" data-input="#filterTable-input" class="info"><b><%=((Client)clients.get(i)).getClientName()%></b></th>
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
							<h4>Project Resources:</h4>
							<%
							System.out.println("running from import.jsp");
							
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
		
</body>
</html>



