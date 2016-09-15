package com.repository.sql.implementation;

import com.model.User;
import com.model.util.PropertiesMessage;
import com.model.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class UserDbQuery extends DbQuery<User> {

    private static UserDbQuery dbRepository;
    PropertiesMessage properties = new PropertiesMessage();

    private UserDbQuery() {
    }

    public static UserDbQuery getInstance() {
        if (dbRepository == null) dbRepository = new UserDbQuery();
        return dbRepository;

    }

    @Override
    public List<User> select(String query) throws SQLException {
        List<User> result = new ArrayList<>();
        try  (Connection connection = DriverManager.getConnection(PropertiesMessage.getDbMessage("dataBaseUrl"), PropertiesMessage.getDbMessage("dataBaseLogIn"), PropertiesMessage.getDbMessage("dataBasePassword"));
              Statement statement = connection.createStatement();
              ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()) {
                User user = new User();

                int id = resultSet.getInt(properties.getDbMessage("userId"));
                String name = resultSet.getString(properties.getDbMessage("userName"));
                String pass = resultSet.getString(properties.getDbMessage("userPassword"));

                user.setId(id);
                user.setName(name);
                user.setPassword(pass);
                result.add(user);
            }
        } catch (SQLException e) {
            Util.printMessage(e.getSQLState());
        }
        return result;
    }

}
