package com.repository.sql.implementation;

import com.model.User;
import com.model.util.DBConnection;
import com.model.util.Util;
import com.repository.sql.interfaces.DataSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDbQuery implements DataSql<User> {

    private static UserDbQuery dbRepository;
    private DBConnection connection = new DBConnection();

    private UserDbQuery() {
    }

    public static UserDbQuery getInstance() {
        if (dbRepository == null) dbRepository = new UserDbQuery();
        return dbRepository;

    }

    @Override
    public void insert(String query) throws SQLException {
        connection.getConnection();

        try (Statement stmt = connection.getStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> select(String query) throws SQLException {
        List<User> result = new ArrayList<>();
        try (Statement stmt = connection.getStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                User user = new User();

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pass = rs.getString("password");
//                int sales = rs.getInt("SALES");
//                int total = rs.getInt("TOTAL");

//                result=id + ", " + name + ", " + pass;
//                System.out.println(id + ", " + name + ", " + pass);
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

    @Override
    public void update(String query) throws SQLException {
        connection.getStatement();

        try (Statement st = connection.getStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            Util.printMessage(e.getSQLState());
        }

//

    }

    @Override
    public void delete(String query) throws SQLException {
        connection.getConnection();

        try (Statement stmt = connection.getStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
