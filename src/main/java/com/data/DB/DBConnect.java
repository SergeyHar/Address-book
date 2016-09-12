package com.data.DB;

import java.sql.*;


public class DBConnect {

    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book", "root", "root");

            st = conn.createStatement();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getData() {
        try {
            String query = "SELECT * FROM USER";
            rs =st.executeQuery(query);
            System.out.println("Records from DB");
            while (rs.next()){
                String name = rs.getString("name");
                String pass= rs.getString("password");
                System.out.println(name +"  "+pass);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}