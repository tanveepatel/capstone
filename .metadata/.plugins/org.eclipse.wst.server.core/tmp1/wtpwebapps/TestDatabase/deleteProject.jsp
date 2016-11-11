<%@ page import="databaseOp.*"%>

<%@ page import="java.util.*"%>

<%@ page import="java.sql.*"%>

<%@ page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>

<body>



<%


DatabaseOperations dao = new DatabaseOperations();

   

String pname = request.getParameter("pname");

dao.deleteProject(pname);

%>


<%

getServletContext().getRequestDispatcher("/1project.jsp").include(request, response);




%>



</body>

</html>