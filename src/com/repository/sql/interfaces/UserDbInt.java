package com.repository.sql.interfaces;

import com.model.User;
import com.model.util.InvalidArgumentException;

import java.sql.SQLException;
import java.util.List;

public interface UserDbInt {
    User addUser(User user) throws InvalidArgumentException, SQLException;

    User editUser(User user , User newUser ) throws InvalidArgumentException, SQLException;

    void deleteUser(int userId) throws InvalidArgumentException, SQLException;

    User getUser(int userId) throws InvalidArgumentException, SQLException;

    User getUser(String userName) throws InvalidArgumentException, SQLException;

    List<User> getUsers() throws InvalidArgumentException, SQLException;

    User addFriend(int userId, int setUserId) throws InvalidArgumentException, SQLException;

    List<User> getFriends(int userId) throws InvalidArgumentException, SQLException;

    void deleteFriend(int userId, int friendId) throws InvalidArgumentException, SQLException;

    boolean existByUsername(String userName) throws InvalidArgumentException, SQLException;
}
