/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-11-18 16:54:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import model.*;
import databaseOp.*;

public final class _2clients_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("databaseOp");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<!-- Include meta tag to ensure proper rendering and touch zooming -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css\" />\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script src=\"http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style3.css\">\r\n");
      out.write("<title>Client</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Client -->\r\n");
      out.write("\t<div data-role=\"page\" id=\"client\">\r\n");
 
				DatabaseOperations dao=new DatabaseOperations();
				List<Client> clients = new Client();
				clients=dao.getAllClients();
				int size1=clients.size();
				
				
      out.write("\r\n");
      out.write("\t\t<div class=\"thumbnail\">\r\n");
      out.write("\t\t\t<img src=\"css/themes/images/t1logo.png\" />\r\n");
      out.write("\t\t\t<div style=\"float:right\">\r\n");
      out.write("\t\t\t<a>Welcome Home, ");
      out.print(session.getAttribute("name"));
      out.write("!</a>&nbsp;&nbsp;|&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<a href=\"logout.jsp\">LogOut</a>&nbsp;&nbsp;|&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<a href=\"1help.jsp\">Help</a>&nbsp;\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"maintab\" class=\"ui-bar ui-bar-a\">\r\n");
      out.write("\t\t\t\t\t<p style=\"text-align:center; font-size: 20px;font-family: 'Comfortaa', cursive;\">Financial\r\n");
      out.write("\t\t\t\tReporting Tool</p>\r\n");
      out.write("\t\t\t\t<div data-role=\"navbar\" id=\"tabs\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"1home.jsp\" data-icon=\"home\" class=\"ui-corner-all\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"1import.jsp\" data-icon=\"info\" class=\"ui-corner-all\">Import Timesheets</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li ><a href=\"1project.jsp\" data-icon=\"bullets\" class=\"ui-corner-all\">Projects</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t<button data-icon=\"action\" class=\"ui-corner-all\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"background: #2164d1; color: white; width: 269px;\">Reports</button>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"dropdown-content\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"position: fixed; background: #2164d1; color: white; width: 269px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"projectSummaryReport.jsp\">Project Summary Report</a> <a href=\"resourceHours.jsp\">Resource\r\n");
      out.write("\t\t\t\t\t\t\t\t\tAnalysation Report</a> <a href=\"billRateDepartment.jsp\">Bill Rate For Department </a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t<button data-icon=\"user\" class=\"ui-corner-all\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"background: #2164d1; color: white; width: 269px;\">Manage</button>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"dropdown-content\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"position: fixed; background: #2164d1; color: white; width: 267px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"2resources.jsp\">Resources</a> \r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"2clients.jsp\">Clients</a> \r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t<div data-role=\"main\" class=\"ui-content\" style=\"background-color:light-white\">\r\n");
      out.write("\t\t\t<a href=\"addClient.jsp\" data-role=\"button\" data-icon=\"plus\"\r\n");
      out.write("\t\t\t\tdata-iconpos=\"left\" style=\"width: 100px;\">Add Client</a>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t<h2>Client -");
      out.print(size1 );
      out.write("</h2>\r\n");
      out.write("\t\t\t<table cellspacing=\"25\">\r\n");
      out.write("\t\t\t\t<tr><b>\r\n");
      out.write("\t\t\t\t<td><b>Client Name</b></td>\r\n");
      out.write("\t\t\t\t<td><b>Address</b></td>\r\n");
      out.write("\t\t\t\t<td><b>Currency</b></td>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td><td>&nbsp;</td></b></tr>\r\n");
      out.write("\t\t\t");

	    	for(int i=0; i<size1 ;i++)
	    	{
		    
      out.write("\r\n");
      out.write("\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<b>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( ((Client)clients.get(i)).getClientName()  );
      out.write("&nbsp;&nbsp;\t\r\n");
      out.write("\t\t\t\t\t</b>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( ((Client)clients.get(i)).getAddress() );
      out.write("&nbsp;&nbsp;\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( ((Client)clients.get(i)).getCurrency() );
      out.write("&nbsp;&nbsp;\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"editClient.jsp?cname=");
      out.print( ((Client)clients.get(i)).getClientName() );
      out.write("\"><input type=\"button\" value=\"Edit\" style=\"width: 100px;\"></a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"deleteClient.jsp?cname=");
      out.print( ((Client)clients.get(i)).getClientName() );
      out.write("\"><input type=\"button\" value=\"Delete\" style=\"width: 100px;\"></a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\t\t\r\n");
      out.write("\t\t\t\t");

	      	}
      	
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
