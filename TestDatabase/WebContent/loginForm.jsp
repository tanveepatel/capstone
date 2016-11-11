<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="model.*"%>
<%@ page import="databaseOp.*"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include meta tag to ensure proper rendering and touch zooming -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
 

<title>LogIn</title>
</head>
<body>

	<!-- LogIn -->
	<div data-role="page" id="logIn">
	
	<%
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/capstone";
		String user = "root";
		String password = "root";
		String sql = "select usertype from users";
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
	%>
		
		<br><br>
		<div class="thumbnail" style="background:white ;width: 300px; margin-left:auto; margin-right:auto;">
			<img src="css/themes/images/t1logo.png" />
		</div>
				<div class="ui-corner-all custom-corners" style="width: 300px; margin-left:auto;
  margin-right:auto;">
					<div class="ui-bar ui-bar-a" style="background:#40bf80">
					<h3 class="mainheading"
				style="font-size: 20px; font-family: 'Comfortaa', cursive;">Financial
				Reporting Tool</h3><br><br>
				

	<div class="form">

		<form method="post" action="loginValidate.jsp" ">
			User Name<br>
			<input type="text" name="name" placeholder="username" /> 
			Password<br>
			<input type="password" name="password" placeholder="password" />
			
				<%
					
					}

					catch (SQLException sqe)

					{

						out.println("home" + sqe);

					}
				%>
			
			<button type="submit" value="Submit" >Log In</button>
					</form>
					
					</div>
	</div>
	</div>
	</div>
</body>
</html>