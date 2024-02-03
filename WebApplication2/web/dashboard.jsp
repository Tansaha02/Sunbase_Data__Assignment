<%-- 
    Document   : dashboard
    Created on : Feb 3, 2024, 11:53:16 PM
    Author     : Hp
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Record Displayer</title>
    <!-- STEP 2: ADDING INTERNAL STYLE FOR TABLE -->
    <style>
        table, tr, td {
            padding: 10px;
            border: 5px solid yellow;
            border-collapse: collapse;
        }
        th {
            padding: 10px;
            border: 5px solid greenyellow;
            border-collapse: collapse;
            color: chartreuse;
        }
    </style>
</head>
<%
    // STEP 3: DECLARING OBJECTS AND VARIABLES
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    int counter;
%>
<body style="background-color: black">
    <!-- STEP 1: BASIC STRUCTURE OF A TABLE -->
    <table>
        <thead>
            <tr>
                <%
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
                %>
                <th><%= rs.getMetaData().getColumnName(counter) %></th>
                <%
                    }
                %>
                <th>ACTION</th>
            </tr>
        </thead>
        <tbody>
            <%
                // STEP 9: DISPLAYING RECORDS AS TABLE ROWS
                while (rs.next()) {
            %>
            <tr>
                <%
                    for (counter = 1; counter <= rs.getMetaData().getColumnCount(); counter++) {
                %>
                <th><%= rs.getString(counter) %></th>
                <%
                    }
                %>
                <td>
                    <button>Edit</button><button>Delete</button>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
        <tfoot>
            <tr>
                <th colspan="10">&copy; YOUR COMPANY NAME &reg; ALL RIGHTS RESERVED</th>
            </tr>
        </tfoot>
    </table>
    <%
        // STEP 10: CLOSING CONNECTIONS
        rs.close();
        pstmt.close();
        conn.close();
    %>
</body>
</html>
