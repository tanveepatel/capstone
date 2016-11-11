package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseOp.DatabaseOperations;
import model.Resource;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

	private static String INSERT_OR_EDIT = "/1resource.jsp";
	private static String INDEXPAGE = "/index.jsp";
	private  DatabaseOperations dao;

	/**
	 * Default constructor. 
	 */
	public UserController() {
		super();
		System.out.println("Running UserController");
		dao = new DatabaseOperations();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Running do get from usercontroller");

		// TODO Auto-generated method stub
		List<Resource> res = GetResoources();
		System.out.println("Value of res from usercontroller \n"+res);
		request.setAttribute("resources",res);
		RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		view.forward(request, response);
	}

	private List<Resource> GetResoources()
	{
		List<Resource> res = new Resource();
		res=dao.getAllResource();	
		return res;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Running do post from usercontroller");
		// TODO Auto-generated method stub
		Resource res = new Resource();
		res.setFname(request.getParameter("fname"));
		res.setLname(request.getParameter("lname"));
		res.setEmail(request.getParameter("email"));
		res.setPermissions(request.getParameter("permissions"));
		res.setBillRate(request.getParameter("brate"));
		res.setCostRate(request.getParameter("crate"));
		res.setDepartment(request.getParameter("department"));

		//RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		dao.addResource(res);
		request.setAttribute("users","Nimisha from do post" );
		RequestDispatcher view1 = request.getRequestDispatcher(INSERT_OR_EDIT);
		view1.forward(request, response);
	}

}
