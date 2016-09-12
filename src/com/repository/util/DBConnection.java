package com.repository.util;

import java.sql.*;

/**
 * Created by Sergo on 12-Sep-16.
 */
public class DBConnection {
    private Statement statement;
    private Connection connection;

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public DBConnection() {
        try {

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String USERNAME = "root";
        String PASSWORD = "root";
        String URL = "jdbc:mysql://localhost:3306/address_book?useSSL=false&amp;autoReconnect=true";


        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("exav");


        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}
