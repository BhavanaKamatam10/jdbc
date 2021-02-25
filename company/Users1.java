package com.company;

import java.sql.*;

public class Users1 {
    public static void main(String[] args) throws SQLException{
        String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
        String dbUsername = "root";
        String dbPassword = "4190";

        String fullname = "Bhavana";
        String username = "Nik";
        String email = "bhav10@gmail.com";
        String password = "12345";


        try {
            Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);
            String sql = "INSERT INTO users (username,email, fullname, password)"
                    + "VALUES (?,?,?,?)";

           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1,username);
            statement.setString(2, email);
            statement.setString(3,fullname);
            statement.setString(4,password);
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
