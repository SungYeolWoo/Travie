/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2014-12-16 00:03:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.edit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>Imagic 편집 페이지</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-2.1.1.js\"></script>\r\n");
      out.write("<script src=\"../js/edit.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\twidth : 100%;\r\n");
      out.write("\t\tmargin : 0;\r\n");
      out.write("\t\tpadding : 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#container {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#header {\r\n");
      out.write("\t\twidth : 100%;\r\n");
      out.write("\t\theight : 70px;\t\t/* 나중에 크기 조절하면 됨  */\r\n");
      out.write("\t\tborder : 1px solid black;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#content {\r\n");
      out.write("\t\twidth : 78%;\r\n");
      out.write("\t\theight : 750px;\r\n");
      out.write("\t\tfloat : left;\r\n");
      out.write("\t\tborder : 1px solid black;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#cavaszone {\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\twidth:100%;\r\n");
      out.write("\t\theight:100%;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#draw {\r\n");
      out.write("\t\tborder : 1px solid black;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#sidebar {\r\n");
      out.write("\t\twidth : 18%;\r\n");
      out.write("\t\tfloat :right;\r\n");
      out.write("\t\theight : 750px;\r\n");
      out.write("\t\tborder : 1px solid black;\r\n");
      out.write("\t\tpadding-left:5px;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#footer {\r\n");
      out.write("\t\twidth :100%;\r\n");
      out.write("\t\tclear : both;\r\n");
      out.write("\t\theight: 100px;\r\n");
      out.write("\t\tborder : 1px solid black;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<!-- header 영역 -->\r\n");
      out.write("\t\t<div id=\"header\">\r\n");
      out.write("\t\t\t편집 페이지\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<!-- canvas 영역 -->\r\n");
      out.write("\t\t\t<div id=\"cavaszone\">\r\n");
      out.write("\t\t\t\t<canvas id=\"draw\" width=\"500px\" height=\"500px\">\r\n");
      out.write("\t\t\t\t</canvas>\r\n");
      out.write("\t\t\t\t<br/>\t\r\n");
      out.write("\t\t\t\t<button id=\"saveCanvas\" align=\"center\" >이미지저장</button>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"sidebar\">\r\n");
      out.write("\t\t\t<!-- 이미지 미리보기(썸네일) 바 -->\r\n");
      out.write("\t\t\t<div id=\"imageList\">\r\n");
      out.write("\t\t\t\t<div id=\"thumbNail\" class=\"dropzone\" data-folder>\r\n");
      out.write("\t\t\t\t\t<div class=\"tv-default tv-message\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t<!-- 푸터 -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("<img data-f />\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
