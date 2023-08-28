package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String databaseName="bdd_swing_employee";
            String URL="jdbc:mysql://localhost:3306/";
            Connection con= DriverManager.getConnection(URL+databaseName,"root","Vtffnaab01.");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
