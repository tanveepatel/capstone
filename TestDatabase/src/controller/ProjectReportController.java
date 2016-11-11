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
	private DatabaseOperations dao;
	 ResultSet res = null;
	 double res1 = 0.0;
       
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
		if(pname.equals("Select all Project")){
			try {
				res = dao.displayAllProjects();
				res1 = dao.displaySumOfBudget();
				System.out.println(res1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			
		
		
		
		//String fund=request.getParameter("fund");
		
		try{
			res = dao.displayProjectReport(pname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println(res);
		
		request.setAttribute("result", res);
		//request.setAttribute("total",res1);
		RequestDispatcher view2 = request.getRequestDispatcher("/projectreport.jsp");
		view2.forward(request, response);
		
	}

}
