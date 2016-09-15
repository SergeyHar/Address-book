package com.repository.sql.implementation;

import com.model.User;
import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.model.util.PropertiesMessage;
import com.model.util.Util;
import com.repository.sql.interfaces.DataSql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class PhoneNumberDbQuery extends DbQuery<PhoneNumber> {

    private static PhoneNumberDbQuery phoneNumberDbQuery;
    PropertiesMessage properties = new PropertiesMessage();

    private PhoneNumberDbQuery() {
    }

    public static PhoneNumberDbQuery getInstance() {
        if (phoneNumberDbQuery == null) phoneNumberDbQuery = new PhoneNumberDbQuery();
        return phoneNumberDbQuery;

    }

    @Override
    public List<PhoneNumber> select(String query) throws SQLException {
        List<PhoneNumber> result = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(PropertiesMessage.getDbMessage("dataBaseUrl"), PropertiesMessage.getDbMessage("dataBaseLogIn"), PropertiesMessage.getDbMessage("dataBasePassword"));
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            PhoneNumber phoneNumber = new PhoneNumber();
            while (resultSet.next()) {

                int id = resultSet.getInt(properties.getDbMessage("numberId"));
                int userId = resultSet.getInt(properties.getDbMessage("numberUserId"));
                String type = resultSet.getString(properties.getDbMessage("numberType"));
                String number = resultSet.getString(properties.getDbMessage("number"));

                phoneNumber.setId(id);
                phoneNumber.setUserId(userId);
                phoneNumber.setType(Util.checkType(type));
                phoneNumber.setNumber(number);
                result.add(phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
