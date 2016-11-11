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
import model.Client;
import model.Project;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/2clients.jsp";
	private  DatabaseOperations dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
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
				System.out.println("Running do get from client controller");

				// TODO Auto-generated method stub
				List<Client> cli = GetClients();
				System.out.println("Value of pro from clientcontroller \n"+ cli);
				request.setAttribute("clients",cli);
				RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
				view.forward(request, response);
			}
			private List<Client> GetClients()
			{
				List<Client> res = new Client();
				res=dao.getAllClients();	
				return res;
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Running do post from clientcontroller");
		// TODO Auto-generated method stub
		Client res = new Client();
		//client,projectName,projectCode,dateStart,dateEnd
		//notes,invoiceMethod,budget,permissions,tasks,team
		res.setClientName(request.getParameter("name"));
		res.setAddress(request.getParameter("address"));
		res.setCurrency(request.getParameter("currency"));
		
		System.out.println(request.getParameter("name")+"--"+request.getParameter("address")+"--"+
				request.getParameter("currency"));
		//RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		dao.addClient(res);
		request.setAttribute("users","Nimisha from do post" );
		RequestDispatcher view1 = request.getRequestDispatcher(INSERT_OR_EDIT);
		view1.forward(request, response);
		
	}

}
