package com.repository.sql.interfaces;


import java.sql.SQLException;
import java.util.List;

public interface DataSql<T> {

    void insert(String query) throws SQLException;
    List<T> select(String query) throws SQLException;
    void update(String query) throws SQLException;
    void delete(String query) throws SQLException;

}
