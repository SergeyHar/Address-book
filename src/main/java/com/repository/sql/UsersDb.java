package com.repository.sql;

import com.model.User;
import com.model.util.InvalidArgumentException;
import com.model.util.Util;
import com.repository.sql.implementation.UserDbQuery;
import com.repository.sql.interfaces.UserDbInt;

import java.sql.SQLException;
import java.util.List;

public class UsersDb implements UserDbInt {

    private static UsersDb usersDb;
    private final String TABLE_USERS = "users";
    private final String TABLE_FRIENDS = "friends";

    private final String COLUMNS_USERS_ID = "id";
    private final String COLUMNS_USERS_NAME = "name";
    private final String COLUMNS_USERS_PASSWORD = "password";

    private final String COLUMNS_FRIENDS_USER_ID = "user_id";
    private final String COLUMNS_FRIENDS_FRIEND_ID = "friend_id";

    private UsersDb() {

    }

    public static UsersDb getInstance() {
        if (usersDb == null) usersDb = new UsersDb();
        return usersDb;

    }

    @Override
    public User addUser(User user) throws InvalidArgumentException, SQLException {
        User newUser = new User();
        UserDbQuery db = UserDbQuery.getInstance();
        db.insert("INSERT INTO " + TABLE_USERS + " (" + COLUMNS_USERS_NAME + ", " + COLUMNS_USERS_PASSWORD + ") VALUES ('" + user.getName() + "', '" + user.getPassword() + "')");
        newUser = UsersDb.getInstance().getUser(user.getName());
        return newUser;
    }

    @Override
    public User editUser(User user, User newUser) throws InvalidArgumentException, SQLException {
        User getUser = new User();
        UserDbQuery db = UserDbQuery.getInstance();

        db.update("UPDATE " + TABLE_USERS + " SET " + COLUMNS_USERS_NAME + "= " + newUser.getName() + ", " + COLUMNS_USERS_PASSWORD + "=" + newUser.getPassword() + " WHERE " + COLUMNS_USERS_NAME + "=" + user.getName());
        getUser = UsersDb.getInstance().getUser(newUser.getName());
        return getUser;
    }

    @Override
    public void deleteUser(int userId) throws InvalidArgumentException, SQLException {
        UserDbQuery db = UserDbQuery.getInstance();

        db.delete("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMNS_USERS_ID + " =" + userId);
    }

    @Override
    public User getUser(int userId) throws InvalidArgumentException, SQLException {
        User result = new User();
        UserDbQuery db = UserDbQuery.getInstance();

        try {
            List<User> users = db.select("SELECT * FROM " + TABLE_USERS + " WHERE  " + COLUMNS_USERS_ID + "='" + userId + "'");

            if (users.get(0) != null) {
                result = users.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getUser(String userName) throws InvalidArgumentException, SQLException {
        User result = new User();
        UserDbQuery db = UserDbQuery.getInstance();

        try {
            List<User> users = db.select("SELECT * FROM " + TABLE_USERS + " WHERE  " + COLUMNS_USERS_NAME + "='" + userName + "'");

            if (users.get(0) != null) {
                result = users.get(0);
            }
        } catch (SQLException e) {
            Util.printMessage(e.getSQLState());
        }
        return result;
    }

    @Override
    public List<User> getUsers() throws InvalidArgumentException, SQLException {
        UserDbQuery db = UserDbQuery.getInstance();

        return db.select("SELECT * FROM " + TABLE_USERS);
    }

    @Override
    public User addFriend(int userId, int setUserId) throws InvalidArgumentException, SQLException {

        UserDbInt userDb = new UsersDb();
        UserDbQuery db = UserDbQuery.getInstance();

        db.insert("INSERT INTO " + TABLE_FRIENDS + " (" + COLUMNS_FRIENDS_USER_ID + ", " + COLUMNS_FRIENDS_FRIEND_ID + ") VALUES ('" + userId + "', '" + setUserId + "')");
        return userDb.getUser(userId);

    }

    @Override
    public List<User> getFriends(int userId) throws InvalidArgumentException, SQLException {
        UserDbQuery db = UserDbQuery.getInstance();

        return db.select("SELECT name FROM " + TABLE_USERS + " WHERE " + COLUMNS_USERS_ID + " IN (SELECT " + COLUMNS_FRIENDS_FRIEND_ID + " FROM " + TABLE_FRIENDS + " WHERE " + COLUMNS_FRIENDS_USER_ID + "=" + userId + ");");
    }

    @Override
    public void deleteFriend(int userId, int friendId) throws InvalidArgumentException, SQLException {
        UserDbQuery db = UserDbQuery.getInstance();

        db.delete("DELETE FROM " + TABLE_FRIENDS + " WHERE " + COLUMNS_FRIENDS_USER_ID + "= " + userId + " AND " + COLUMNS_FRIENDS_FRIEND_ID + "=" + friendId);

    }

    @Override
    public boolean existByUsername(String userName) throws InvalidArgumentException, SQLException {
        UserDbQuery db = UserDbQuery.getInstance();

        try {
            List<User> users = db.select("SELECT * FROM " + TABLE_USERS + " WHERE  " + COLUMNS_USERS_NAME + " ='" + userName + "'");

            if (users.get(0) != null) {

//                System.out.println(users.get(0).getName() + " done");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
