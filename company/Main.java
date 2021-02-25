package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "4190";


        try {

            myConn = DriverManager.getConnection(url, user, password);

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("Select * from employees");

            while(myRs.next()) {
                System.out.println(myRs.getString("last_name")+","+ myRs.getString("first_name"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }


}
