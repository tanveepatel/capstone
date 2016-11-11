package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import databaseOp.DatabaseOperations;

/**
 * Servlet implementation class editProjectController
 */
@WebServlet("/editProjectController")
public class editProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 JOptionPane optionPane;
	 JFrame frame;
	 private DatabaseOperations dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editProjectController() {
        super();
        // TODO Auto-generated constructor stub
        optionPane= new JOptionPane();
        frame=new JFrame();
        dao = new DatabaseOperations();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("running do get of editController");
		RequestDispatcher view = request.getRequestDispatcher("/1project.jsp");
		view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Autmessagebox.
		System.out.println("running do post of editController");
		int n = optionPane.showConfirmDialog(null,"Are you sure you would like to edit this record?","An Inane Question",JOptionPane.YES_NO_OPTION);

		String result = "";
		switch (n) {
		case JOptionPane.YES_OPTION:
		  result = "YES";
		  break;
		case JOptionPane.NO_OPTION:
		  result = "NO";
		  break;
		default:
		  ;
		}
		System.out.println(n);
		
		String projectname=request.getParameter("projectName");
		String client=request.getParameter("client");
		String projectcode=request.getParameter("projectCode");
		String datestart=request.getParameter("dateStart");
		String dateend=request.getParameter("dateEnd");
		String notes=request.getParameter("notes");
		String invoice=request.getParameter("invoiceMethod");
		//String permission=request.getParameter("permissions");
		String budget=request.getParameter("budget");
		String team=request.getParameter("team");
		
		System.out.println(projectname+"-"+client+"-"+projectcode+"-"+datestart+"-"+dateend+"-"+notes+"-"+invoice+
				"-"+budget+"-"+team+"");
		if(n==0){
			dao.editProject(projectname, client, projectcode, datestart, dateend, notes, invoice,budget, team);
			RequestDispatcher view1 = request.getRequestDispatcher("/1project.jsp");
			view1.forward(request, response);
		}
		else{
		
		RequestDispatcher view1 = request.getRequestDispatcher("/editProject.jsp");
		view1.forward(request, response);
		}
	}

	

}
