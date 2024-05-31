/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2024-05-31 02:03:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.miniProject;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class ResultView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>미니게임결과</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            background-image: linear-gradient(to bottom right, #ff9a9e, #fad0c4);\r\n");
      out.write("            font-family: 'Arial', sans-serif;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            flex-direction: column;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h1 {\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            font-size: 3em;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .result-box {\r\n");
      out.write("            background-color: rgba(255, 255, 255, 0.9);\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .result-label {\r\n");
      out.write("            font-size: 1.2em;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .result-value {\r\n");
      out.write("            font-size: 1.2em;\r\n");
      out.write("            color: #555;\r\n");
      out.write("            margin-bottom: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        a {\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            color: white;\r\n");
      out.write("            background-color: #007BFF;\r\n");
      out.write("            padding: 15px 30px;\r\n");
      out.write("            font-size: 1.2em;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            transition: background-color 0.3s ease;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        a:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1>★ 가위바위보 결과 ★</h1>\r\n");
      out.write("    <div class=\"result-box\">\r\n");
      out.write("        <p class=\"result-label\">당신의 선택:</p>\r\n");
      out.write("        <p class=\"result-value\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${playerMove}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("        <p class=\"result-label\">컴퓨터의 선택:</p>\r\n");
      out.write("        <p class=\"result-value\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${computerMove}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("        <p class=\"result-label\">결과:</p>\r\n");
      out.write("        <p class=\"result-value\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${result}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("        <p class=\"result-label\">현재 HP:</p>\r\n");
      out.write("        <p class=\"result-value\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${game1hp}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <a href=\"http://localhost:8080/jwbook/miniProject/GameView.jsp\">다시 하기</a>\r\n");
      out.write("    <a href=\"http://localhost:8080/jwbook/miniProject/index.jsp\">게임 선택으로 돌아가기</a>\r\n");
      out.write("    <a href=\"http://localhost:8080/jwbook/miniProject/startPage.jsp\">로그아웃</a>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
