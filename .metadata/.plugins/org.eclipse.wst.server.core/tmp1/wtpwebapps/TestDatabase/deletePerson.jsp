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
		String email = request.getParameter("email");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String department = request.getParameter("department");
		String billRate = request.getParameter("billRate");
		String costRate = request.getParameter("costRate");
		String permission = request.getParameter("permission");
		Resource res = new Resource();
		res.setFname(fname);
		res.setLname(lname);
		res.setEmail(email);
		res.setBillRate(billRate);
		res.setCostRate(costRate);
		res.setDepartment(department);
		res.setPermissions(permission);
		dao.addDelResource(res);
	%>

	<%
		dao.deleteResource(email);
		getServletContext().getRequestDispatcher("/2resources.jsp").include(request, response);
	%>




</body>

</html>