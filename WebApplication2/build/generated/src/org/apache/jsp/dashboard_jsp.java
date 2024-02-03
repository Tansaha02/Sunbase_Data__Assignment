package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Record Displayer</title>\n");
      out.write("    <!-- STEP 2: ADDING INTERNAL STYLE FOR TABLE -->\n");
      out.write("    <style>\n");
      out.write("        table, tr, td {\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 5px solid yellow;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 5px solid greenyellow;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            color: chartreuse;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");

    // STEP 3: DECLARING OBJECTS AND VARIABLES
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    int counter;

      out.write("\n");
      out.write("<body style=\"background-color: black\">\n");
      out.write("    <!-- STEP 1: BASIC STRUCTURE OF A TABLE -->\n");
      out.write("    <table>\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                ");

                    // STEP 4: REGISTERING MYSQL DRIVER
                    Class.forName("com.mysql.jdbc.Driver");
                    
                    // STEP 5: INSTANTIATING THE CONNECTION
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tanmoy", "tanmoy", "1234");
                    
                    // STEP 6: INSTANTIATING THE PREPARED STATEMENT OBJECT
                    pstmt = conn.prepareStatement("SELECT * FROM customer");
                    
                    // STEP 7: EXECUTING THE QUERY
                    rs = pstmt.executeQuery();
                    
                    // STEP 8: RETRIEVING COLUMN NAMES
                    for (counter = 1; counter <= rs.getMetaData().getColumnCount(); counter++) {
                
      out.write("\n");
      out.write("                <th>");
      out.print( rs.getMetaData().getColumnName(counter) );
      out.write("</th>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                <th>ACTION</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                // STEP 9: DISPLAYING RECORDS AS TABLE ROWS
                while (rs.next()) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                ");

                    for (counter = 1; counter <= rs.getMetaData().getColumnCount(); counter++) {
                
      out.write("\n");
      out.write("                <th>");
      out.print( rs.getString(counter) );
      out.write("</th>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                <td>\n");
      out.write("                    <button>Edit</button><button>Delete</button>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("        <tfoot>\n");
      out.write("            <tr>\n");
      out.write("                <th colspan=\"10\">&copy; YOUR COMPANY NAME &reg; ALL RIGHTS RESERVED</th>\n");
      out.write("            </tr>\n");
      out.write("        </tfoot>\n");
      out.write("    </table>\n");
      out.write("    ");

        // STEP 10: CLOSING CONNECTIONS
        rs.close();
        pstmt.close();
        conn.close();
    
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
