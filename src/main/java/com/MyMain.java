package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyMain {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");
// Load the Connector/J driver
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("test");
            Connection conn = DriverManager.getConnection(url, username, password);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
/*
// Establish connection to MySQL

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
*/
//        DBConnect dbConnect=  new DBConnect();
//        dbConnect.getData();


//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery("SELECT NAME FROM USER");
//
//            // or alternatively, if you don't know ahead of time that
//            // the query will be a SELECT...
//
//            if (stmt.execute("SELECT NAME FROM USER")) {
//                rs = stmt.getResultSet();
//            }
//
//            // Now do something with the ResultSet ....
//        } catch (SQLException ex) {
//            // handle any errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        } finally {
//            // it is a good idea to release
//            // resources in a finally{} block
//            // in reverse-order of their creation
//            // if they are no-longer needed
//
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException sqlEx) {
//                } // ignore
//
//                rs = null;
//            }
//
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException sqlEx) {
//                } // ignore
//
//                stmt = null;
//            }
//        }






/*
        ControllerInt c = new Controller();
        Util.printMessage("Please write path where you want your program working");
        Util.path = c.inputCommand();
        Util.printMessage("Please write down one of this commands \"Sign In\" or \"Sign Up\"");
        c.start();
*/

    }
}
