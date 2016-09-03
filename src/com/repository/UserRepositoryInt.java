package com.repository;

import com.model.User;
import com.model.util.MyExceptions;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.List;

public interface UserRepositoryInt {
     void addUser(User user) throws InvalidArgumentException;

     User editUser(User user) throws InvalidArgumentException;

    void deleteUser(int userId) throws InvalidArgumentException;

    List<User> getUsers(int userId) throws InvalidArgumentException;

    User addFriend(int userId, int setUserId) throws InvalidArgumentException;

    List<User> getFriends(int userId) throws InvalidArgumentException;
    void deleteFriend(int friendId) throws InvalidArgumentException;

    User checkUser(User user) throws InvalidArgumentException, MyExceptions;

}
