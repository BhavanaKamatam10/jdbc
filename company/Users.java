package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Users {
    public static void main(String[] args) throws SQLException{
        String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "4190";


        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "INSERT INTO users (username,email, fullname, password)"
                    + "VALUES ('Bhavana', 'bhavana98.kamatam@gmail.com', 'root', '4190')";

            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if(rows > 0){
                System.out.println("A new user has been inserted carefully");
            }

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
