package com.repository.svc;

import com.model.User;
import com.model.util.InvalidArgumentException;

import java.util.List;

public interface UserRepositoryInt {
    void addUser(User user) throws InvalidArgumentException;

    User editUser(User user) throws InvalidArgumentException;

    void deleteUser(int userId) throws InvalidArgumentException;

    List<User> getUsers() throws InvalidArgumentException;

    User addFriend(int userId, int setUserId) throws InvalidArgumentException;

    List<User> getFriends(int userId) throws InvalidArgumentException;

    void deleteFriend(int userId, int friendId) throws InvalidArgumentException;

    User existingUserCheckup(User user) throws InvalidArgumentException;

}
