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
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Hp
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        // Initialize database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/tanmoy";
        String dbUser = "root";
        String dbPassword = "1234";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a database connection
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                // Prepare and execute a SQL query
                String sql = "SELECT * FROM customer WHERE email = ? AND password = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, username);
                    statement.setString(2, password);

                    // Execute the query
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            // Authentication successful
                            HttpSession session = request.getSession(true);
                            session.setAttribute("username", username);

                            response.sendRedirect("dashboard.jsp");
                        } else {
                            // Authentication failed, handle accordingly
                            response.sendRedirect("login.jsp");
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
    }
}