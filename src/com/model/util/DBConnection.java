package com.model.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

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
        String USERNAME = "root";
        String PASSWORD = "root";
        String URL = "jdbc:mysql://localhost:3306/address_book?useSSL=false&amp;autoReconnect=true";

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("connecting");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
