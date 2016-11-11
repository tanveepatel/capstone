package controller;

import java.awt.List;
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
 * Servlet implementation class ViewReportController
 */
@WebServlet("/ViewReportController")
public class ViewReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DatabaseOperations dao;
	 ResultSet res,res1 = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReportController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new DatabaseOperations();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("running do get of View Report Controller");
		//RequestDispatcher view = request.getRequestDispatcher("/viewReport.jsp");
		//view.forward(request, response);		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("running do post of View Report Controller");
		
		//Resource res = new Resource();
		//client,projectName,projectCode,dateStart,dateEnd
		//notes,invoiceMethod,budget,permissions,tasks,team
		String fname= request.getParameter("fname");
		String pname = request.getParameter("projectName");
		System.out.println(pname);
		String sdate=request.getParameter("dateFrom");
		String edate=request.getParameter("dateTo");
				
		
		try {
			res = dao.displayInvoiceReport(pname);
			
			//res1=dao.displayInvoiceReportResouces(pname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		System.out.println(fname+"--"+pname+"--"+sdate+"--"+edate+"--"+res);
		request.setAttribute("fname", fname);
		request.setAttribute("result", res);
		RequestDispatcher view1 = request.getRequestDispatcher("/viewInvoiceReport.jsp");
		view1.forward(request, response);	
	}

}
