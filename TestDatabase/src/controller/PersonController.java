package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseOp.DatabaseOperations;
import model.Project;
import model.Resource;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("/PersonController")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/2resources.jsp";
	private  DatabaseOperations dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonController() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Running PersonController");
		dao = new DatabaseOperations();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				System.out.println("Running do get from person controller");

				// TODO Auto-generated method stub
				List<Resource> pro = GetResource();
				System.out.println("Value of pro from person controller \n"+ pro);
				request.setAttribute("persons",pro);
				RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
				view.forward(request, response);
			}
	
			private List<Resource> GetResource()
			{
				List<Resource> res = new Resource();
				res=dao.getAllResource();	
				return res;
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Running do post from person controller");
		// TODO Auto-generated method stub
		Resource res = new Resource();
		//client,projectName,projectCode,dateStart,dateEnd
		//notes,invoiceMethod,budget,permissions,tasks,team
		res.setFname(request.getParameter("fname"));
		res.setLname(request.getParameter("lname"));
		res.setBillRate(request.getParameter("brate"));
		res.setCostRate(request.getParameter("crate"));
		res.setPermissions(request.getParameter("permissions"));
		res.setDepartment(request.getParameter("department"));
		res.setEmail(request.getParameter("email"));
		
		
		
		System.out.println(request.getParameter("fname")+"--"+request.getParameter("lname")+"--"+
				request.getParameter("brate")+"--"+request.getParameter("crate")+"--"+
				request.getParameter("permissions")+"--"+request.getParameter("department")+"--"+
				request.getParameter("email"));
		//RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		dao.addResource(res);
		request.setAttribute("users","Nimisha from do post" );
		RequestDispatcher view1 = request.getRequestDispatcher(INSERT_OR_EDIT);
		view1.forward(request, response);
	}

}
