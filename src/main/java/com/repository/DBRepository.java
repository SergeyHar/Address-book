package com.repository;

import com.model.util.DBConnection;

import java.sql.ResultSet;

/**
 * Created by Sergo on 12-Sep-16.
 */
public class DBRepository  implements  DBRepositoryInt{

    private static DBRepository dbRepository;
    private DBConnection connection = new DBConnection();

    private DBRepository() {
    }

    public static DBRepository getInstance() {
        if (dbRepository == null) dbRepository = new DBRepository();
        return dbRepository;

    }




    @Override
    public void insert(String query) {

    }

    @Override
    public ResultSet select(String query) {
        return null;
    }

    @Override
    public void update(String query) {

    }

    @Override
    public void delete(String query) {

    }
}
