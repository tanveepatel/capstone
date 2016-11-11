package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import javax.servlet.RequestDispatcher;
import databaseOp.DatabaseOperations;
import model.*;

/**
 * Servlet implementation class homeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/1home.jsp";
	private  DatabaseOperations dao;
	private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("Running homeController");
        dao = new DatabaseOperations();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*System.out.println("Running do get from homecontroller");
		session=request.getSession();
		
		// TODO Auto-generated method stub
		List<Project> project = new Project();
		project=dao.getAllProjects();
		
		List<FileData> filedata = new FileData();
		filedata=dao.getAllFileData();
		
		List<Resource> resource = new Resource();
		resource=dao.getAllResource();
		
		int numResource=dao.getNumResourc();
		int numProject=dao.getNumProject();
		int numClient=dao.getNumClient();
		
		System.out.println("Value from homecontroller \n"+project+"\n"+filedata+"\n"+resource+"\n"+numResource+
				"\n"+numProject+"\n"+numClient);
		
		session.setAttribute("projects",project);
		session.setAttribute("filedatas",filedata);
		session.setAttribute("resources",resource);*/
		
		RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
