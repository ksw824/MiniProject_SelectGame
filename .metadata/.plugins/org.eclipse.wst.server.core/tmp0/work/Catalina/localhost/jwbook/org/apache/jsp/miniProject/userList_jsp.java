/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2024-05-31 12:57:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.miniProject;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.*;
import miniProject.UserDAO;
import miniProject.User;

public final class userList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1713231525000L));
    _jspx_dependants.put("jar:file:/Users/sunwookim/Desktop/Major/WpWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/jwbook/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("miniProject.User");
    _jspx_imports_classes.add("miniProject.UserDAO");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>회원 목록</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n");
      out.write("<style>\n");
      out.write("    body {\n");
      out.write("        font-family: Arial, sans-serif;\n");
      out.write("        background-color: #f4f4f4;\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("    }\n");
      out.write("    .container {\n");
      out.write("        width: 80%;\n");
      out.write("        margin: auto;\n");
      out.write("        overflow: hidden;\n");
      out.write("    }\n");
      out.write("    header {\n");
      out.write("        background: #50b3a2;\n");
      out.write("        color: #fff;\n");
      out.write("        padding-top: 30px;\n");
      out.write("        min-height: 70px;\n");
      out.write("        border-bottom: #2980b9 3px solid;\n");
      out.write("    }\n");
      out.write("    header a {\n");
      out.write("        color: #fff;\n");
      out.write("        text-decoration: none;\n");
      out.write("        text-transform: uppercase;\n");
      out.write("        font-size: 16px;\n");
      out.write("    }\n");
      out.write("    header ul {\n");
      out.write("        padding: 0;\n");
      out.write("        list-style: none;\n");
      out.write("    }\n");
      out.write("    header li {\n");
      out.write("        float: left;\n");
      out.write("        display: inline;\n");
      out.write("        padding: 0 20px 0 20px;\n");
      out.write("    }\n");
      out.write("    header #branding {\n");
      out.write("        float: left;\n");
      out.write("    }\n");
      out.write("    header #branding h1 {\n");
      out.write("        margin: 0;\n");
      out.write("    }\n");
      out.write("    header nav {\n");
      out.write("        float: right;\n");
      out.write("        margin-top: 10px;\n");
      out.write("    }\n");
      out.write("    table {\n");
      out.write("        width: 100%;\n");
      out.write("        margin-top: 20px;\n");
      out.write("        border-collapse: collapse;\n");
      out.write("    }\n");
      out.write("    table, th, td {\n");
      out.write("        border: 1px solid #ddd;\n");
      out.write("    }\n");
      out.write("    table th, table td {\n");
      out.write("        padding: 10px;\n");
      out.write("        text-align: left;\n");
      out.write("    }\n");
      out.write("    table th {\n");
      out.write("        background: #50b3a2;\n");
      out.write("        color: #fff;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div id=\"branding\">\n");
      out.write("            <h1>학생정보 시스템</h1>\n");
      out.write("        </div>\n");
      out.write("        <nav>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"http://localhost:8080/jwbook/miniproject/startPage.jsp\">홈</a></li>\n");
      out.write("                <li><a href=\"http://localhost:8080/jwbook/miniproject/join.jsp\">회원가입</a></li>\n");
      out.write("                <li><a href=\"http://localhost:8080/jwbook/miniproject/userList.jsp\">회원목록</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>회원 목록</h2>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>아이디</th>\n");
      out.write("            <th>이름</th>\n");
      out.write("            <th>게임1 기록</th>\n");
      out.write("            <th>게임2 기록</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

            UserDAO userDao = new UserDAO();
            List<User> users = userDao.getAll();
            for (User user : users) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( user.getId() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( user.getName() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( user.getGame1hp() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( user.getGame2hp() );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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