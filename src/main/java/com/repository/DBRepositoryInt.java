package com.repository;

import java.sql.ResultSet;

/**
 * Created by Sergo on 12-Sep-16.
 */
public interface DBRepositoryInt {
    void insert(String query);
    ResultSet select(String query);
    void update(String query);
    void delete(String query);

}
