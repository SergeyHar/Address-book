package com.repository;

import java.util.List;

import com.model.User;
import com.sun.javaws.exceptions.InvalidArgumentException;

public interface UserRepositoryInterface {
    public void addUser(User user) throws InvalidArgumentException;

    public User editUser(User user) throws InvalidArgumentException;

    public void delateUser(int userId) throws InvalidArgumentException;

    public List<User> getUsers(int userId) throws InvalidArgumentException;

    public void addFriend(int userId, int setUserId) throws InvalidArgumentException;

    public List<User> getFriends(int userId) throws InvalidArgumentException;

}
