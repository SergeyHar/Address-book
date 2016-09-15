package com.repository.sql.implementation;

import com.model.util.PropertiesMessage;
import com.model.util.Util;
import com.repository.sql.interfaces.DataSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Sergo on 14-Sep-16.
 */
public abstract class DbQuery<T> implements DataSql {

    @Override
    public void insert(String query) throws SQLException {

        try (Connection connection = DriverManager.getConnection(PropertiesMessage.getDbMessage("dataBaseUrl"), PropertiesMessage.getDbMessage("dataBaseLogIn"), PropertiesMessage.getDbMessage("dataBasePassword"));
             Statement statement = connection.createStatement()) {

            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String query) throws SQLException {

        try (Connection connection = DriverManager.getConnection(PropertiesMessage.getDbMessage("dataBaseUrl"), PropertiesMessage.getDbMessage("dataBaseLogIn"), PropertiesMessage.getDbMessage("dataBasePassword"));
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            Util.printMessage(e.getSQLState());
        }
    }

    @Override
    public void delete(String query) throws SQLException {
        try (Connection connection = DriverManager.getConnection(PropertiesMessage.getDbMessage("dataBaseUrl"), PropertiesMessage.getDbMessage("dataBaseLogIn"), PropertiesMessage.getDbMessage("dataBasePassword"));
             Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
