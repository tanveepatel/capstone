package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import databaseOp.DatabaseOperations;
import databaseOp.readFile;

/**
 * Servlet implementation class UploadController
 */
@WebServlet("/UploadController")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/1import.jsp";
	
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	private DatabaseOperations dao;
       
   
    public UploadController() {
        super();
        
        System.out.println("Running UploadController");
		dao = new DatabaseOperations();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Running do get from uploadcontroller");
		// session=request.getSession();
		//request.setAttribute("message", " ");
		RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
		view.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Running do post from uploadservlet");

		// checks if the request actually contains upload file
		//String name=ServletFileUpload
		System.out.println(request.getContentType());
		if (!ServletFileUpload.isMultipartContent(request)) 
		{
			PrintWriter writer = response.getWriter();
			writer.println("Request does not contain upload data");
			System.out.println("Request does not contain upload data");
			writer.flush();
			return;
		}

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		String uploadPath = getServletContext().getRealPath("") + File.separator + "upload";
		// String uploadPath1= "C:\\TEMP";
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			List formItems = upload.parseRequest(request);
			Iterator iter = formItems.iterator();

			// iterates over form's fields
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// processes only fields that are not form fields
				if (!item.isFormField()) {
					String fileName = new File(item.getName()).getName();
					System.out.println(fileName);
					String filePath = uploadPath + File.separator + fileName;
					System.out.println(filePath);
					File storeFile = new File(filePath);

					// saves the file on disk
					item.write(storeFile);
					String filename = "";
					// String path = "D:\\Capstone Project
					// Versions\\Capstone_v3\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\TestDatabase\\upload\\"+filename;

					filename = fileName;
					// System.out.println(path);

					readFile rf = new readFile();
					rf.rFile(filePath);

				}
			}
			System.out.println("Upload has been done successfully!");
			
			JOptionPane.showMessageDialog ( 
					null, "   Upload has been done successfully", "Message", JOptionPane.PLAIN_MESSAGE);
			
			request.setAttribute("message", "Upload has been done successfully!");

		} catch (Exception ex) {
			System.out.println("error!");
			JOptionPane.showMessageDialog ( 
					null, "Please upload csv file", "  Upload was unsuccessful", JOptionPane.ERROR_MESSAGE);
			request.setAttribute("message", "There was an error: " + ex.getMessage());
		}
		RequestDispatcher view1 = request.getRequestDispatcher(INSERT_OR_EDIT);
		view1.forward(request, response);
	}

}
