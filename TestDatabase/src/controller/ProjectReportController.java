package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Resource;
import databaseOp.DatabaseOperations;

/**
 * Servlet implementation class ProjectReportController
 */
@WebServlet("/ProjectReportController")
public class ProjectReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String jspToRedirect="/projectreport.jsp";
	private DatabaseOperations dao;
	 ResultSet res = null;
	 double res1 = 0.0;
	 //ResultSet res2 = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReportController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new DatabaseOperations();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("running do post of Project Report Controller");
		// TODO Auto-generated method stub
		
		String pname= request.getParameter("name");
		System.out.println("value of name" +pname);
		if(pname.equals("Select all Project"))
		{
			try {
				res = dao.displayAllProjects();
				res1 = dao.displaySumOfBudget();
				System.out.println(res1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jspToRedirect="/projectreport.jsp";
		}
		
		else{
		
		//String fund=request.getParameter("fund");
		
		try{
			res = dao.displaySingleProject(pname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jspToRedirect="/singleProject.jsp";
		}
		System.out.println(res);
		//System.out.println(res2);
		
		request.setAttribute("result", res);
		
	request.setAttribute("pname",pname);
		RequestDispatcher view2 = request.getRequestDispatcher(jspToRedirect);
		view2.forward(request, response);
		
	}

}
