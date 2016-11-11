<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<title>Log Out</title>
</head>
</head>

<body>
<% session.invalidate(); %>

			<div class="thumbnail">
			<img src="css/themes/images/t1logo.png" />
			</div>
				<div class="ui-corner-all custom-corners">
					<div class="ui-bar ui-bar-a" style="background:#40bf80">
					<h1 class="mainheading" style="font-size: 25px; font-family: 'Comfortaa', cursive;">
				You have been successfully logged out!</h1>
					<a href="loginForm.jsp">Log back in</a>	
					
				</div>
				</div>	

</body>
</html>