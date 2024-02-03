/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpages;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "form", urlPatterns = {"/form"})
public class form extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   // JDBC URL, username, and password of MySQL server
      String URL = "jdbc:mysql://localhost:3306/tanmoy";
     String USER = "root";
     String PASSWORD = "1234";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error loading MySQL JDBC Driver", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve customer data from the form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        
     

    try (
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO customer (firstname,lastname,street,address,city,state,email,Phone_no,Password) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            )
        ) {
            // Set parameters for the SQL query
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, street);
        preparedStatement.setString(4, address);
        preparedStatement.setString(5, city);
        preparedStatement.setString(6, state);
        preparedStatement.setString(7, email);
        preparedStatement.setString(8, phone);
        preparedStatement.setString(9, password);

            // Execute the SQL query
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            // Handle exceptions as needed
            
        }

        // Redirect to a thank you or confirmation page (you can use JSP for this)
        response.sendRedirect("login.jsp");
    }
}