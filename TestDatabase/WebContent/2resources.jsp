<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>

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
<title>Resource</title>
</head>
<body>

	<!-- Resource -->
	<div data-role="page" id="resource">
<% 
				DatabaseOperations dao=new DatabaseOperations();
				List<Resource> resources = new Resource();
				resources=dao.getAllResource();
				int size1=resources.size();
				
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
				
				<div style=background:navy"></div>
				<div data-role="navbar" id="secondmaintab">
				<ul>
					<li><a href="2resources.jsp" class="ui-corner-all" >Resources</a></li>
					<li><a href="2clients.jsp" class="ui-corner-all" >Clients</a></li>
					
						
				</ul>
				</div>	
				</div>
		<div data-role="main" class="ui-content" style="background-color:light-white">
			<a href="addPerson.jsp" data-role="button" data-icon="plus"
				data-iconpos="left" style="width: 100px;">Add Resource</a>
			<div>
			<h2>Resource -<%=size1 %></h2>
		<table cellspacing="25">
		<tr><b>
		<td><b>First Name&nbsp;&nbsp;</b></td>
		<td><b>Last Name&nbsp;&nbsp;</b></td>
		<td><b>Department&nbsp;&nbsp;</b></td>
		<td><b>Email&nbsp;&nbsp;</b></td>
		<td><b>Cost Rate&nbsp;&nbsp;</b></td>
		<td><b>Bill Rate&nbsp;&nbsp;</b></td>
		<td><b>Permissions&nbsp;&nbsp;</b></td>
		<td>&nbsp;</td><td>&nbsp;</td></b></tr>
			<%
	    	for(int i=0; i<size1 ;i++)
	    	{
		   	%>
				<tr>
					<td>
					<b>
						<%= ((Resource)resources.get(i)).getFname()  %>&nbsp;&nbsp;
					</b>
					</td>
					<td>
					<b>
						<%= ((Resource)resources.get(i)).getLname()  %>&nbsp;&nbsp;
					</b>
					</td>
					<td>
					<b>
						<%= ((Resource)resources.get(i)).getDepartment() %>&nbsp;&nbsp;
					</b>
					</td>
					<td>
					<b>			
						<%= ((Resource)resources.get(i)).getEmail() %>&nbsp;&nbsp;
					</b>
					</td>
					<td>
					<b>			
						<%= ((Resource)resources.get(i)).getCostRate() %>&nbsp;&nbsp;
					</b>
					</td>
					<td>
					<b>			
						<%= ((Resource)resources.get(i)).getBillRate() %>&nbsp;&nbsp;
					</b>
					</td>
					<td>
					<b>	
						<%= ((Resource)resources.get(i)).getPermissions() %>&nbsp;&nbsp;	
					</b>
					</td>
					<td>
						<a href="editPerson.jsp?email=<%=((Resource) resources.get(i)).getEmail()%>"><input type="button" value="Edit" style="width: 100px;"></a>
					</td>
					<td> 
						<a href="deletePerson.jsp?email=<%=((Resource) resources.get(i)).getEmail()%>&fname= <%=((Resource) resources.get(i)).getFname()%>&lname=<%=((Resource) resources.get(i)).getLname()%>&department=<%=((Resource) resources.get(i)).getDepartment()%>&costRate=<%=((Resource) resources.get(i)).getCostRate()%>&billRate=<%=((Resource) resources.get(i)).getBillRate()%>&permission=<%=((Resource) resources.get(i)).getPermissions()%>"><input type="button" value="Delete" style="width: 100px;"></a>
					</td>
				</tr>		
				<%
	      	}
      	%>
		</table>
		</div>
		</div>
			
	</div>
</body>
</html>