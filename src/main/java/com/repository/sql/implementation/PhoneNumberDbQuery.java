package com.repository.sql.implementation;

import com.model.phonenumber.PhoneNumber;
import com.repository.sql.interfaces.DataSql;

import java.sql.SQLException;
import java.util.List;


public class PhoneNumberDbQuery implements DataSql<PhoneNumber> {
    @Override
    public void insert(String query) throws SQLException {

    }

    @Override
    public List<PhoneNumber> select(String query) throws SQLException {
        return null;
    }

    @Override
    public void update(String query) throws SQLException {

    }

    @Override
    public void delete(String query) throws SQLException {

    }
}
