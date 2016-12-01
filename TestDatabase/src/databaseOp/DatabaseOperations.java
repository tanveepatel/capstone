/*package databaseOp;

import java.sql.Connection;
import java.sql.Date;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import model.Client;
import model.FileData;
import model.Project;
import model.Resource;
import util.Database;

public class DatabaseOperations {
	Connection connection;
	PreparedStatement preparedStatement;

	public DatabaseOperations() {
		connection = Database.getConnection();
	}

	public Resource getResourceById(String resourceId) {
		// TODO Auto-generated method stub
		System.out.print(resourceId + " From GetResourceId Method");
		Resource res = new Resource();
		try {
			preparedStatement = this.connection
					.prepareStatement("select * from resource where fname=?");
			System.out.println(" prepared " + preparedStatement.toString());
			preparedStatement.setString(1, resourceId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				res.setFname(rs.getString("fname"));
				res.setLname(rs.getString("lname"));
				res.setEmail(rs.getString("email"));
				res.setDepartment(rs.getString("department"));
				res.setBillRate(rs.getString("billRate"));
				res.setCostRate(rs.getString("costRate"));
				res.setPermissions(rs.getString("permission"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public List<Resource> getAllResource() {
		List<Resource> reses = new ArrayList<Resource>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from resource order by id desc");
			while (rs.next()) {
				Resource res = new Resource();
				res.setFname(rs.getString("fname"));
				res.setLname(rs.getString("lname"));
				res.setEmail(rs.getString("email"));
				res.setDepartment(rs.getString("department"));
				res.setBillRate(rs.getString("billRate"));
				res.setCostRate(rs.getString("costRate"));
				res.setPermissions(rs.getString("permission"));
				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reses;
	}

	public int insertFileDataRow(String date, String fName, String lName,
			String project, String hours) throws ClassNotFoundException,
			IllegalAccessException, InstantiationException, SQLException {
		Connection c = Database.getConnection();
		Statement st = (Statement) c.createStatement();
		String sql = "INSERT INTO fileData  VALUES ('0','" + date + "', '"
				+ fName + "', '" + lName + "','" + project + "', '" + hours
				+ "')";
		int res = st.executeUpdate(sql);
		c.close();
		System.out.println("from insert file data");
		return res;
	}

	public List<FileData> getAllFileData() {
		// TODO Auto-generated method stub
		List<FileData> reses = new ArrayList<FileData>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from filedata");
			while (rs.next()) {
				FileData res = new FileData();
				res.setDate(rs.getString("date"));
				res.setFname(rs.getString("fname"));
				res.setLname(rs.getString("lname"));
				res.setProject(rs.getString("project"));
				res.setHoure(rs.getString("hours"));
				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getAllFileData " + reses);
		return reses;
	}

	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		List<Project> reses = new ArrayList<Project>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from project order by id desc;");
			while (rs.next()) {
				Project res = new Project();
				res.setClient(rs.getString("client"));
				res.setProjectName(rs.getString("name"));
				res.setProjectCode(rs.getString("code"));
				res.setDateStart(rs.getString("sdate"));
				res.setDateEnd(rs.getString("edate"));
				res.setNotes(rs.getString("notes"));
				res.setInvoiceMethod(rs.getString("invoice"));
				res.setBudget(rs.getString("budget"));
				// res.setPermissions(rs.getString("permissions"));
				res.setTeam(rs.getString("team"));
				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reses;
	}

	public Project getProject(String pname) {
		// TODO Auto-generated method stub
		Project res = new Project();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from project where name='" + pname
							+ "'");
			System.out.println(rs);
			while (rs.next()) {

				res.setClient(rs.getString("client"));
				res.setProjectName(rs.getString("name"));
				res.setProjectCode(rs.getString("code"));
				res.setDateStart(rs.getString("sdate"));
				res.setDateEnd(rs.getString("edate"));
				res.setNotes(rs.getString("notes"));
				res.setInvoiceMethod(rs.getString("invoice"));
				res.setBudget(rs.getString("budget"));
				res.setPermissions(rs.getString("permissions"));
				res.setTeam(rs.getString("team"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
	}

	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		List<Client> reses = new ArrayList<Client>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from clients order by id desc");
			while (rs.next()) {
				Client res = new Client();
				res.setClientName(rs.getString("clientname"));
				res.setAddress(rs.getString("address"));
				res.setCurrency(rs.getString("currency"));

				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reses;
	}

	public int getNumResourc() {
		int count = 0;
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select count(*)num from resource");
			while (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getNumResource " + count);
		return count;
	}

	public int getNumProject() {
		int count = 0;
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select count(*)num from project");
			while (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getNumProject " + count);
		return count;
	}

	public int getNumClient() {
		int count = 0;
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select count(*)num from clients");
			while (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getNumClient " + count);
		return count;
	}

	public void addClient(Client res) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection
					.prepareStatement("insert into clients(clientname,address,currency) values (?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, res.getClientName());
			preparedStatement.setString(2, res.getAddress());
			preparedStatement.setString(3, res.getCurrency());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addResource(Resource res) {
		try {
			preparedStatement = connection
					.prepareStatement("insert into resource(fname,lname,email,department,billRate,costRate,permission) values (?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, res.getFname());
			preparedStatement.setString(2, res.getLname());
			preparedStatement.setString(3, res.getEmail());
			preparedStatement.setString(4, res.getDepartment());
			preparedStatement.setString(5, res.getBillRate());
			preparedStatement.setString(6, res.getCostRate());
			preparedStatement.setString(7, res.getPermissions());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProject(Project res) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection
					.prepareStatement("insert into project(client,name,code,sdate,edate,notes,invoice,budget,team) values (?,?,?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, res.getClient());
			preparedStatement.setString(2, res.getProjectName());
			preparedStatement.setString(3, res.getProjectCode());
			preparedStatement.setString(4, res.getDateStart());
			preparedStatement.setString(5, res.getDateEnd());
			preparedStatement.setString(6, res.getNotes());
			preparedStatement.setString(7, res.getInvoiceMethod());
			preparedStatement.setString(8, res.getBudget());
			preparedStatement.setString(9, res.getTeam());
			// preparedStatement.setString(10, res.getPermissions());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int editProject(String projectname, String client,
			String projectcode, String datestart, String dateend, String notes,
			String invoice, String permission, String budget, String team) {
		// TODO Auto-generated method stub
		int projectId;
		int res = 0;
		try {
			projectId = getProjectId(projectname);
			System.out.println(projectId + " from edit project method");
			Connection c = Database.getConnection();
			Statement st = (Statement) c.createStatement();
			String sql = "UPDATE project SET client='" + client + "', name='"
					+ projectname + "', code='" + projectcode + "', sdate='"
					+ datestart + "', edate='" + dateend + "',notes='" + notes
					+ "', invoice='" + invoice + "', permissions='"
					+ permission + "', budget='" + budget + "', team='" + team
					+ "' WHERE id=" + projectId + "";
			System.out.println(sql);
			res = st.executeUpdate(sql);
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	private int getProjectId(String projectname) {
		// TODO Auto-generated method stub
		int id = 0;
		Connection c = Database.getConnection();
		Statement st;
		try {
			st = (Statement) c.createStatement();
			String sql = "SELECT id FROM project WHERE name='" + projectname
					+ "'";
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				id = res.getInt("id");
				System.out.println(id + " from get project id method");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	// public void deleteResource(String email) {
	// try {
	// String sql = "DELETE FROM resource WHERE email =?";
	// PreparedStatement prest = connection.prepareStatement(sql);
	// prest.setString(1, email);
	// int val = prest.executeUpdate();
	// final JDialog dialog = new JDialog();
	// dialog.setAlwaysOnTop(true);
	// JOptionPane.showMessageDialog(dialog,
	// "The record has been successfully deleted");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }

	public void deleteResource(String email) {
		try {
			final JOptionPane optionPane = new JOptionPane(
					"Are you sure you want to delete this person?",
					JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
			JDialog dialog = optionPane.createDialog("Confirm Deletion");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			if (optionPane.getValue().equals(JOptionPane.YES_OPTION)) {
				final JDialog dialog2 = new JDialog();
				String sql = "DELETE FROM resource WHERE email =?";
				PreparedStatement prest = connection.prepareStatement(sql);
				prest.setString(1, email);
				int val = prest.executeUpdate();
				JOptionPane.showMessageDialog(dialog2,
						"The record has been successfully deleted");
				dialog2.setAlwaysOnTop(true);
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addDelResource(Resource res) {
		try {
			preparedStatement = connection
					.prepareStatement("insert into deletedresources(fname,lname,email,department,billRate,costRate,permission) values (?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, res.getFname());
			preparedStatement.setString(2, res.getLname());
			preparedStatement.setString(3, res.getEmail());
			preparedStatement.setString(4, res.getDepartment());
			preparedStatement.setString(5, res.getBillRate());
			preparedStatement.setString(6, res.getCostRate());
			preparedStatement.setString(7, res.getPermissions());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// public void deleteClient(String cname) {
	//
	// try {
	// String sql = "DELETE FROM clients WHERE clientname=?";
	// PreparedStatement prest = connection.prepareStatement(sql);
	// prest.setString(1,cname );
	// int val = prest.executeUpdate();
	// final JDialog dialog = new JDialog();
	// dialog.setAlwaysOnTop(true);
	// JOptionPane.showMessageDialog(dialog,
	// "The record has been successfully deleted");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	public void deleteProject(String pname) {

		try {

			final JOptionPane optionPane = new JOptionPane(
					"Are you sure you want to delete this project?",

					JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);

			JDialog dialog = optionPane.createDialog("Confirm Deletion");

			dialog.setAlwaysOnTop(true);

			dialog.setVisible(true);

			if (optionPane.getValue().equals(JOptionPane.YES_OPTION)) {

				final JDialog dialog2 = new JDialog();

				String sql = "DELETE FROM project WHERE name =?";

				PreparedStatement prest = connection.prepareStatement(sql);

				prest.setString(1, pname);

				int val = prest.executeUpdate();

				JOptionPane.showMessageDialog(dialog2,
						"The record has been successfully deleted");

				dialog2.setAlwaysOnTop(true);

			} else {

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public ResultSet displayInvoiceReport(String pname) throws SQLException {
		Connection c = Database.getConnection();
		Statement st;

		// String sql1 =
		// "select project.code, project.name, project.sdat, project.edate,project.budget,resource.fname, resource.lname, resource.billRate FROM project";
		// String
		// sql="select filedata.project,filedata.hours  from capstone.filedata where fname='"+fname+"'";
		String sql1 = "select project.code,project.name,project.sdate,project.budget from capstone.project where project.name='"
				+ pname + "'";
		System.out.println(sql1);
		st = (Statement) c.createStatement();
		ResultSet res = st.executeQuery(sql1);
		System.out.println(res);

		return res;

	}

	// public void deleteClient(String cname) {
	//
	// try {
	// String sql = "DELETE FROM clients WHERE clientname=?";
	// PreparedStatement prest = connection.prepareStatement(sql);
	// prest.setString(1, cname);
	// int val = prest.executeUpdate();
	// final JDialog dialog = new JDialog();
	// dialog.setAlwaysOnTop(true);
	// JOptionPane.showMessageDialog(dialog,
	// "The record has been successfully deleted");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }

	public void deleteClient(String cname) {

		try {

			final JOptionPane optionPane = new JOptionPane(
					"Are you sure you want to delete this client?",

					JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);

			JDialog dialog = optionPane.createDialog("Confirm Deletion");

			dialog.setAlwaysOnTop(true);

			dialog.setVisible(true);

			if (optionPane.getValue().equals(JOptionPane.YES_OPTION)) {

				final JDialog dialog2 = new JDialog();

				String sql = "DELETE FROM clients WHERE clientname =?";

				PreparedStatement prest = connection.prepareStatement(sql);

				prest.setString(1, cname);

				int val = prest.executeUpdate();

				JOptionPane.showMessageDialog(dialog2,
						"The record has been successfully deleted");

				dialog2.setAlwaysOnTop(true);

			} else {

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public double getSumProjectHours(String project) {
		String sql = "SELECT SUM(hours) FROM filedata WHERE project=?";
		PreparedStatement prest;
		ResultSet rs;
		double value = 0;

		try {
			prest = connection.prepareStatement(sql);
			prest.setString(1, project);
			rs = prest.executeQuery();

			if (!rs.next()) {
				value = 0.0;

			} else {
				String sum = rs.getString(1);
				if (sum != null) {
					System.out.println(sum);
					value = Double.parseDouble(sum);
				} else {
					value = 0;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public double getSumHours(String fname, String project) {
		String sql = "SELECT SUM(hours) FROM filedata WHERE fname=? AND project=?";
		
		PreparedStatement prest;
		ResultSet rs;
		double value = 0.0;

		try {
			prest = connection.prepareStatement(sql);
			prest.setString(1, fname);
			prest.setString(2, project);
			rs = prest.executeQuery();
			
			//System.out.println("output of sql query of getSumHours method " + sql);
			//String h = rs.getString("hours");
			//=System.out.println(h);
			if (!rs.next()) {
				value = 0.0;
			} else {
				String sum = rs.getString(1);
				if (sum != null) {
					System.out.println(sum);
					value = Double.parseDouble(sum);
				} else {
					value = 0;
				}
				// System.out.println("running from dopeartion" + sum);
				//sum = "8";
				System.out.println("running from databaseoperation");
				System.out.println(sum);
				value = Double.parseDouble(sum);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public List<Project> getAllClientProjects(String clientName) {

		List<Project> clientProjects = new ArrayList<Project>();

		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select * from project where client='"
							+ clientName + "'");
			while (rs.next()) {
				Project project = new Project();
				project.setProjectName(rs.getString("name"));
				project.setProjectCode(rs.getString("code"));
				project.setTeam(rs.getString("team"));
				clientProjects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientProjects;

	}

	public ResultSet displayInvoiceReportResouces(String pname) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
*/


package databaseOp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;




import org.json.simple.JSONArray;

import com.mysql.jdbc.Statement;

import model.Client;
import model.FileData;
import model.Project;
import model.Resource;
import util.Database;


public class DatabaseOperations {
	Connection connection;
	PreparedStatement preparedStatement;

	public DatabaseOperations() {
		connection = Database.getConnection();
	}

	public Resource getResourceById(String resourceId) {
		// TODO Auto-generated method stub
		System.out.print(resourceId + " From GetResourceId Method");
		Resource res = new Resource();
		try {
			preparedStatement = this.connection.prepareStatement("select * from resource where fname=?");
			System.out.println(" prepared " + preparedStatement.toString());
			preparedStatement.setString(1, resourceId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				res.setFname(rs.getString("fname"));
				res.setLname(rs.getString("lname"));
				res.setEmail(rs.getString("email"));
				res.setDepartment(rs.getString("department"));
				res.setBillRate(rs.getString("billRate"));
				res.setCostRate(rs.getString("costRate"));
				res.setPermissions(rs.getString("permission"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public List<Resource> getAllResource() {
		List<Resource> reses = new ArrayList<Resource>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from resource order by id desc");
			while (rs.next()) {
				Resource res = new Resource();
				res.setFname(rs.getString("fname"));
				res.setLname(rs.getString("lname"));
				res.setEmail(rs.getString("email"));
				res.setDepartment(rs.getString("department"));
				res.setBillRate(rs.getString("billRate"));
				res.setCostRate(rs.getString("costRate"));
				res.setPermissions(rs.getString("permission"));
				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reses;
	}

	public int insertFileDataRow(String date, String fName, String lName, String project, String hours)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
		Connection c = Database.getConnection();
		Statement st = (Statement) c.createStatement();
		String sql = "INSERT INTO fileData  VALUES ('0','" + date + "', '" + fName + "', '" + lName + "','" + project
				+ "', '" + hours + "')";
		int res = st.executeUpdate(sql);
		c.close();
		return res;
	}
	
	public List<Project> getAllClientProjects(String clientName) {
		
		List<Project> clientProjects = new ArrayList<Project>();
		
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from project where client='" + clientName + "'");
			while (rs.next()) {
				Project project = new Project();
				project.setProjectName(rs.getString("name"));
				project.setProjectCode(rs.getString("code"));
				project.setTeam(rs.getString("team"));
				clientProjects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientProjects;
		
		
	}
	
	public int editProject(String projectname, String client,
			String projectcode, String datestart, String dateend, String notes,
			String invoice, String permission, String budget, String team) {
		// TODO Auto-generated method stub
		int projectId;
		int res = 0;
		try {
			projectId = getProjectId(projectname);
			System.out.println(projectId + " from edit project method");
			Connection c = Database.getConnection();
			Statement st = (Statement) c.createStatement();
			String sql = "UPDATE project SET client='" + client + "', name='"
					+ projectname + "', code='" + projectcode + "', sdate='"
					+ datestart + "', edate='" + dateend + "',notes='" + notes
					+ "', invoice='" + invoice + "', permissions='"
					+ permission + "', budget='" + budget + "', team='" + team
					+ "' WHERE id=" + projectId + "";
			System.out.println(sql);
			res = st.executeUpdate(sql);
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public Client getClient(String cname) {
		// TODO Auto-generated method stub
		System.out.println("In getClient method--");
    	
		Client res = new Client();
        try {
            Statement statement = (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from clients where clientname='"+cname+"'");
            System.out.println(rs);
            while (rs.next()) {
                
        		res.setClientName(rs.getString("clientname"));
        		res.setAddress(rs.getString("address"));
        		res.setCurrency(rs.getString("currency"));
        		System.out.println("From getClient method--"+rs.getString("clientname")+"---"+rs.getString("address")+"---"+rs.getString("currency"));
        	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(res);
        return res;
	}

	public int getClientId(String clientName) {
		// TODO Auto-generated method stub
		System.out.println("From getClientId method--"+clientName);
		int id=0;
		Connection c = Database.getConnection();
    	Statement st;
		try {
			st = (Statement) c.createStatement();
			String sql="SELECT id FROM clients WHERE clientname='"+clientName+"'";
			System.out.println(sql);
	    	ResultSet res =st.executeQuery(sql);
	    	while(res.next())
	    	{
	    		id=res.getInt("id");
	    		System.out.println(id+" from get client id method");
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return id;
	}
	
	public int editClient(int id,String clientName, String address, String currancy)  {
		// TODO Auto-generated method stub
		
		int res=0;
		try {
			//System.out.println(+" from edit clients method");
			Connection c = Database.getConnection();
	    	Statement st = (Statement) c.createStatement();
			String sql ="UPDATE clients SET clientname='"+clientName+"', address='"+address+"', currency='"+currancy+"' WHERE id="+id+"";
	
			System.out.println(sql); 
			res =st.executeUpdate(sql);
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public List<FileData> getAllFileData() {
		// TODO Auto-generated method stub
		List<FileData> reses = new ArrayList<FileData>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from filedata");
			while (rs.next()) {
				FileData res = new FileData();
				res.setDate(rs.getString("date"));
				res.setFname(rs.getString("fname"));
				res.setLname(rs.getString("lname"));
				res.setProject(rs.getString("project"));
				res.setHoure(rs.getString("hours"));
				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getAllFileData " + reses);
		return reses;
	}

	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		List<Project> reses = new ArrayList<Project>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from project order by id desc;");
			while (rs.next()) {
				Project res = new Project();
				res.setClient(rs.getString("client"));
				res.setProjectName(rs.getString("name"));
				res.setProjectCode(rs.getString("code"));
				res.setDateStart(rs.getString("sdate"));
				res.setDateEnd(rs.getString("edate"));
				res.setNotes(rs.getString("notes"));
				res.setInvoiceMethod(rs.getString("invoice"));
				res.setBudget(rs.getString("budget"));
				res.setTeam(rs.getString("team"));
				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reses;
	}

   
	public Project getProject(String pname) {
		// TODO Auto-generated method stub
		Project res = new Project();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from project where name='" + pname + "'");
			System.out.println(rs);
			while (rs.next()) {

				res.setClient(rs.getString("client"));
				res.setProjectName(rs.getString("name"));
				res.setProjectCode(rs.getString("code"));
				res.setDateStart(rs.getString("sdate"));
				res.setDateEnd(rs.getString("edate"));
				res.setNotes(rs.getString("notes"));
				res.setInvoiceMethod(rs.getString("invoice"));
				res.setBudget(rs.getString("budget"));
				res.setTeam(rs.getString("team"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(res);
		return res;
	}

	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		List<Client> reses = new ArrayList<Client>();
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from clients order by id desc");
			while (rs.next()) {
				Client res = new Client();
				res.setClientName(rs.getString("clientname"));
				res.setAddress(rs.getString("address"));
				res.setCurrency(rs.getString("currency"));

				reses.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reses;
	}

	public int getNumResourc() {
		int count = 0;
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*)num from resource");
			while (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getNumResource " + count);
		return count;
	}

	public int getNumProject() {
		int count = 0;
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*)num from project");
			while (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getNumProject " + count);
		return count;
	}

	public int getNumClient() {
		int count = 0;
		try {
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*)num from clients");
			while (rs.next()) {
				count = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("From getNumClient " + count);
		return count;
	}

	public void addClient(Client res) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection
					.prepareStatement("insert into clients(clientname,address,currency) values (?,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, res.getClientName());
			preparedStatement.setString(2, res.getAddress());
			preparedStatement.setString(3, res.getCurrency());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addResource(Resource res) {
		try {
			preparedStatement = connection.prepareStatement(
					"insert into resource(fname,lname,email,department,billRate,costRate,permission) values (?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, res.getFname());
			preparedStatement.setString(2, res.getLname());
			preparedStatement.setString(3, res.getEmail());
			preparedStatement.setString(4, res.getDepartment());
			preparedStatement.setString(5, res.getBillRate());
			preparedStatement.setString(6, res.getCostRate());
			preparedStatement.setString(7, res.getPermissions());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProject(Project res) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = connection.prepareStatement(
					"insert into project(client,name,code,sdate,edate,notes,invoice,budget,team) values (?,?,?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, res.getClient());
			preparedStatement.setString(2, res.getProjectName());
			preparedStatement.setString(3, res.getProjectCode());
			preparedStatement.setString(4, res.getDateStart());
			preparedStatement.setString(5, res.getDateEnd());
			preparedStatement.setString(6, res.getNotes());
			preparedStatement.setString(7, res.getInvoiceMethod());
			preparedStatement.setString(8, res.getBudget());
			preparedStatement.setString(9, res.getTeam());
			

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int editProject(String projectname, String client, String projectcode, String datestart, String dateend,
			String notes, String invoice, String budget, String team) {
		// TODO Auto-generated method stub
		int projectId;
		int res = 0;
		try {
			projectId = getProjectId(projectname);
			System.out.println(projectId + " from edit project method");
			Connection c = Database.getConnection();
			Statement st = (Statement) c.createStatement();
			String sql = "UPDATE project SET client='" + client + "', name='" + projectname + "', code='" + projectcode
					+ "', sdate='" + datestart + "', edate='" + dateend + "',notes='" + notes + "', invoice='" + invoice
					+ "', budget='" + budget + "', team='" + team + "' WHERE id="
					+ projectId + "";
			System.out.println(sql);
			res = st.executeUpdate(sql);
			c.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	private int getProjectId(String projectname) {
		// TODO Auto-generated method stub
		int id = 0;
		Connection c = Database.getConnection();
		Statement st;
		try {
			st = (Statement) c.createStatement();
			String sql = "SELECT id FROM project WHERE name='" + projectname + "'";
			ResultSet res = st.executeQuery(sql);
			while (res.next()) {
				id = res.getInt("id");
				System.out.println(id + " from get project id method");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	public void deleteResource(String email) {
		try {
			final JOptionPane optionPane = new JOptionPane("Are you sure you want to delete this person?",
					JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
			JDialog dialog = optionPane.createDialog("Confirm Deletion");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			if (optionPane.getValue().equals(JOptionPane.YES_OPTION)) {
				final JDialog dialog2 = new JDialog();
				String sql = "DELETE FROM resource WHERE email =?";
				PreparedStatement prest = connection.prepareStatement(sql);
				prest.setString(1, email);
				int val = prest.executeUpdate();
				JOptionPane.showMessageDialog(dialog2, "The record has been successfully deleted");
				dialog2.setAlwaysOnTop(true);
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addDelResource(Resource res) {
		try {
			preparedStatement = connection.prepareStatement(
					"insert into deletedresources(fname,lname,email,department,billRate,costRate,permission) values (?,?,?,?,?,?,? )");
			// Parameters start with 1
			preparedStatement.setString(1, res.getFname());
			preparedStatement.setString(2, res.getLname());
			preparedStatement.setString(3, res.getEmail());
			preparedStatement.setString(4, res.getDepartment());
			preparedStatement.setString(5, res.getBillRate());
			preparedStatement.setString(6, res.getCostRate());
			preparedStatement.setString(7, res.getPermissions());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteClient(String cname) {

		try {
			final JOptionPane optionPane = new JOptionPane("Are you sure you want to delete this client?",
					JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
			JDialog dialog = optionPane.createDialog("Confirm Deletion");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			if (optionPane.getValue().equals(JOptionPane.YES_OPTION)) {
				final JDialog dialog2 = new JDialog();
				String sql = "DELETE FROM clients WHERE clientname =?";
				PreparedStatement prest = connection.prepareStatement(sql);
				prest.setString(1, cname);
				int val = prest.executeUpdate();
				JOptionPane.showMessageDialog(dialog2, "The record has been successfully deleted");
				dialog2.setAlwaysOnTop(true);
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public double getSumProjectHours(String project) {
		//System.out.print("from getSumproject method");
		String sql = "SELECT SUM(hours) FROM filedata WHERE project=?";
		PreparedStatement prest;
		ResultSet rs;
		double value = 0.0;
		
		try {
			prest = connection.prepareStatement(sql);
			prest.setString(1,project);
			rs = prest.executeQuery();
			
			if (!rs.next()){
				value = 0.0;
				
			} else {
		    String sum = rs.getString(1);
		    if (sum != null) {
		    System.out.println(sum);
		    value = Double.parseDouble(sum);
		    } else {
		    	value = 0;
		    }
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	

	
	public double getSumHours(String fname, String project) {
		String sumresult="";
		//String sql = "SELECT SUM(hours) as '" + sumresult + "' FROM filedata WHERE fname=? AND project=?";
		String sql = "SELECT SUM(hours) as total FROM filedata WHERE fname=? AND project=?";
		PreparedStatement prest;
		ResultSet rs;
		double value = 0;
		
		try {
			prest = connection.prepareStatement(sql);
			prest.setString(1,fname);
			prest.setString(2,project);
			rs = prest.executeQuery();
			
			//System.out.println("sumresultset = "+ sumresult);
			if (!rs.next()){
				value = 0.0;
				
			} else {
		    String sum = rs.getString(1);
		    if (sum != null) {
		    //System.out.println(sum);
		    value = Double.parseDouble(sum);
		    } else {
		    	value = 0;
		    }
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public void deleteProject(String pname) {

		try {
			final JOptionPane optionPane = new JOptionPane("Are you sure you want to delete this project?",
					JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
			JDialog dialog = optionPane.createDialog("Confirm Deletion");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			if (optionPane.getValue().equals(JOptionPane.YES_OPTION)) {
				final JDialog dialog2 = new JDialog();
				String sql = "DELETE FROM project WHERE name =?";
				PreparedStatement prest = connection.prepareStatement(sql);
				prest.setString(1, pname);
				int val = prest.executeUpdate();
				JOptionPane.showMessageDialog(dialog2, "The record has been successfully deleted");
				dialog2.setAlwaysOnTop(true);
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet displayInvoiceReport(String pname) throws SQLException {
		Connection c = Database.getConnection();
		Statement st;

		// String sql1 =
		// "select project.code, project.name, project.sdat, project.edate,project.budget,resource.fname, resource.lname, resource.billRate FROM project";
		// String
		// sql="select filedata.project,filedata.hours  from capstone.filedata where fname='"+fname+"'";
		String sql1 = "select project.code,project.name,project.sdate,project.budget from capstone.project where project.name='"
				+ pname + "'";
		System.out.println(sql1);
		st = (Statement) c.createStatement();
		ResultSet res = st.executeQuery(sql1);
		System.out.println(res);

		return res;

	}

	public ResultSet displayAllProjects() throws SQLException
	{
		Connection c = Database.getConnection();
	Statement st;
	//String sql1 = "select SUM(project.budget)FROM capstone.project";
	 String sql="select project.name,project.code,project.invoice,project.sdate,project.budget from capstone.project";
	 System.out.println(sql);
	 st = (Statement) c.createStatement();
	 ResultSet res =st.executeQuery(sql);
	 System.out.println(res);
	
	return res;
	}
	
	public double displaySumOfBudget() throws SQLException
	{
		System.out.println("running displaysumBudget");
		String sql = "select SUM(project.budget)FROM capstone.project";
		PreparedStatement prest;
		 ResultSet res1;
		 double value=0.0;
		 
		 try{
			 
			 prest=connection.prepareStatement(sql);
			 res1=prest.executeQuery();
			 Double sum= res1.getDouble(1);
			 //value= Double.parseDouble(sum);
			 value=sum;
			 System.out.println(value);
			 
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		
		// TODO Auto-generated method stub
		return value;
	}

	public ResultSet displayProjectReport(String pname) throws SQLException {
		Connection c = Database.getConnection();
    	Statement st;
		
		//String sql1 = "select project.code, project.name, project.sdat, project.edate,project.budget,resource.fname, resource.lname, resource.billRate FROM project";
		 String sql="select project.name,project.code,project.invoice,project.sdate,project.budget from capstone.project where name='"+pname+"'";
		 //System.out.println(sql);
		 st = (Statement) c.createStatement();
		 ResultSet res =st.executeQuery(sql);
		// System.out.println(res);
		
		return res;
		
		}
	public String getTotalBudget() {

		String sql = "SELECT SUM(budget) from project";
		double budget = 0;
		String amount = null;

		try {
			ResultSet rs = null;
			PreparedStatement stm1 = connection.prepareStatement(sql);
			rs = stm1.executeQuery(sql);

			while (rs.next()) {
				budget = rs.getDouble(1);
				NumberFormat formatter = NumberFormat.getCurrencyInstance();
				amount = formatter.format(budget);
			}

		} catch (Exception ex) {
			System.out.println("<h1>" + ex + "</g1>");
		}
		return amount;
	}
	public JSONArray generateJSON() {

		String sql = "SELECT distinct(project) as project, sum(hours) as hours from filedata group by project";
		JSONArray list = new JSONArray();
		ArrayList arrTest = null;

		try {
			ResultSet rs = null;
			PreparedStatement stm1 = connection.prepareStatement(sql);
			rs = stm1.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				// JSONObject obj=new JSONObject();
				arrTest = new ArrayList();
				if (i == 0) {
					arrTest.add("Projects");
					arrTest.add("Hours");
					i++;
				} else {
					arrTest.add(rs.getString("project"));
					arrTest.add(rs.getDouble("hours"));
				}
				list.add(arrTest);
			}

			System.out.print("JSON Array " + list);
		} catch (Exception ex) {
			System.out.println("<h1>" + ex + "</g1>");
		}
		return list;
	}
	
	public JSONArray generateDeptAvgRateJSON() {

		String sql = "SELECT distinct(department) as department, avg(billRate) as billRate from resource group by department";
		JSONArray list = new JSONArray();
		ArrayList arrTest = null;

		try {
			ResultSet rs = null;
			PreparedStatement stm1 = connection.prepareStatement(sql);
			rs = stm1.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				
				arrTest = new ArrayList();
				if (i == 0) {
					arrTest.add("Department");
					arrTest.add("Average Rate");
					i++;
				} else {
					arrTest.add(rs.getString("department"));
					arrTest.add(rs.getDouble("billRate"));
				}
				list.add(arrTest);
			}

			System.out.print("JSON Array " + list);
		} catch (Exception ex) {
			System.out.println("<h1>" + ex + "</g1>");
		}
		return list;
	}
	
	public JSONArray generateResourceJSON() {

		String sql = "SELECT distinct(fname) as fname, sum(hours) as hours from filedata group by fname";
		JSONArray list = new JSONArray();
		ArrayList arrTest = null;

		try {
			ResultSet rs = null;
			PreparedStatement stm1 = connection.prepareStatement(sql);
			rs = stm1.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				
				arrTest = new ArrayList();
				if (i == 0) {
					arrTest.add("Resource");
					arrTest.add("Hours");
					i++;
				} else {
					arrTest.add(rs.getString("fname"));
					arrTest.add(rs.getDouble("hours"));
				}
				list.add(arrTest);
			}

			System.out.print("JSON Array " + list);
		} catch (Exception ex) {
			System.out.println("<h1>" + ex + "</g1>");
		}
		return list;
	}
	
	
	public JSONArray generateJSON1() {

		String sql = "SELECT distinct(name) as project, sum(budget) as budget from project group by name";
		JSONArray list = new JSONArray();
		ArrayList arrTest = null;

		try {
			ResultSet rs = null;
			PreparedStatement stm1 = connection.prepareStatement(sql);
			rs = stm1.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				// JSONObject obj=new JSONObject();
				arrTest = new ArrayList();
				if (i == 0) {
					arrTest.add("Projects");
					arrTest.add("Budget");
					i++;
				} else {
					arrTest.add(rs.getString("project"));
					arrTest.add(rs.getDouble("budget"));
				}
				list.add(arrTest);
			}

			System.out.print("JSON Array " + list);
		} catch (Exception ex) {
			System.out.println("<h1>" + ex + "</g1>");
		}
		return list;
	}
	
	public JSONArray generateJSON2() {

		String sql = "select name, budget, client, sum(hours) as TotalHours from project left join filedata on name=project group by project;";
		JSONArray list = new JSONArray();
		ArrayList arrTest = null;

		try {
			System.out.print("running from json2");
			ResultSet rs = null;
			PreparedStatement stm1 = connection.prepareStatement(sql);
			rs = stm1.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				// JSONObject obj=new JSONObject();
				arrTest = new ArrayList();
				if (i == 0) {
					arrTest.add("Projects");
					arrTest.add("Budget");
					arrTest.add("Client");
					arrTest.add("Total Hours");
					i++;
				} else {
					arrTest.add(rs.getString("name"));
					arrTest.add(rs.getDouble("budget"));
					arrTest.add(rs.getString("client"));
					arrTest.add(rs.getDouble("TotalHours"));
					
				}
				list.add(arrTest);
			}

			System.out.print("JSON Array " + list);
		} catch (Exception ex) {
			System.out.println("<h1>" + ex + "</g1>");
		}
		return list;
	}
	
	

	public void displayProperCSVFileMessage() {
		 JOptionPane.showMessageDialog ( 
					null, "Please upload proper csv file", "  Upload was unsuccessful", JOptionPane.ERROR_MESSAGE);
     	 
    	       // System.exit(0);
//     	
		
		
		
		}
	
}
