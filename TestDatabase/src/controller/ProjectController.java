package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import databaseOp.DatabaseOperations;
import model.*;

/**
 * Servlet implementation class ProjectController
 */
@WebServlet("/ProjectController")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/1project.jsp";
	private  DatabaseOperations dao;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Running UserController");
		dao = new DatabaseOperations();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Running do get from projectcontroller");

		// TODO Auto-generated method stub
		List<Project> pro = GetProjects();
		System.out.println("Value of pro from projectcontroller \n"+ pro);
		request.setAttribute("projects",pro);
		RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		view.forward(request, response);
	}
	private List<Project> GetProjects()
	{
		List<Project> res = new Project();
		res=dao.getAllProjects();	
		return res;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Running do post from projectcontroller");
		// TODO Auto-generated method stub
		Project res = new Project();
		//client,projectName,projectCode,dateStart,dateEnd
		//notes,invoiceMethod,budget,permissions,tasks,team
		res.setClient(request.getParameter("client"));
		res.setProjectName(request.getParameter("projectName"));
		res.setProjectCode(request.getParameter("projectCode"));
		res.setDateStart(request.getParameter("dateStart"));
		res.setDateEnd(request.getParameter("dateEnd"));
		res.setNotes(request.getParameter("notes"));
		res.setInvoiceMethod(request.getParameter("invoiceMethod"));
		res.setBudget(request.getParameter("budget"));
		String team = Arrays.toString(request.getParameterValues("team")).replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .trim();
		res.setTeam(team);
		System.out.println(request.getParameter("client")+"--"+request.getParameter("projectName")+"--"+
				request.getParameter("projectCode")+"--"+request.getParameter("dateStart")+"--"+
				request.getParameter("dateEnd")+"--"+request.getParameter("notes")+"--"+
				request.getParameter("invoiceMethod")+"--"+request.getParameter("budget")+"--"+
				request.getParameter("team"));
		//RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		dao.addProject(res);
		request.setAttribute("users","Nimisha from do post" );
		RequestDispatcher view1 = request.getRequestDispatcher(INSERT_OR_EDIT);
		view1.forward(request, response);
	}

}
