/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-11-18 16:58:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addClient_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
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
      out.write("<title>Add Client</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Add Client -->\r\n");
      out.write("\t<div data-role=\"page\" id=\"addClient\">\r\n");
      out.write("<div class=\"thumbnail\">\r\n");
      out.write("\t\t\t<img src=\"css/themes/images/t1logo.png\" />\r\n");
      out.write("\t\t\t<div style=\"float:right\">\r\n");
      out.write("\t\t\t<a>Welcome Home, ");
      out.print(session.getAttribute("name"));
      out.write("!</a>&nbsp;&nbsp;|&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<a href=\"logout.jsp\">Log Out</a>&nbsp;&nbsp;|&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<a href=\"1help.jsp\">Help</a>&nbsp;\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"maintab\" class=\"ui-bar ui-bar-a\">\r\n");
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
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t<div data-role=\"main\" class=\"ui-content\" style=\"background-color:light-white\">\t\t\r\n");
      out.write("\t\t\t<form method=\"post\" action=\"ClientController \" name=\"formClient\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 20%; margin: 0 auto; width: 100%; text-align: left\">\r\n");
      out.write("\t\t\t\t<h3>Add Client</h3>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"cname\">Name:</label></td> \r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"name\" id=\"name\" required></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"address\">Address:</label></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"address\" id=\"address\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"select-native-1\">Currency:</label></td> \r\n");
      out.write("\t\t\t\t\t<td><select name=\"currency\" id=\"select-native-1\" required>\r\n");
      out.write("\t\t\t\t\t<option value=\"cad\">CAD</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"usd\">USD</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"gdp\">GDP</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"eur\">EUR</option>\r\n");
      out.write("\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"submit\" value=\"Add\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t \t</table>\r\n");
      out.write("\t\t\t</div>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
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
