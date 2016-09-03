package com.repository;

import com.data.Data;
import com.data.FriendData;
import com.data.UserData;
import com.model.User;
import com.model.util.MyExceptions;
import com.model.util.Util;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepository implements UserRepositoryInt {
    Data data = new UserData();
    Data dataFriend = new FriendData();


    @Override
    public void addUser(User user) throws InvalidArgumentException {

        data.fileWriter(Util.projectDirectory(), user);
    }

    @Override
    public User editUser(User user) throws InvalidArgumentException {


        return null;
    }

    @Override
    public void deleteUser(int userId) throws InvalidArgumentException {
        // TODO Auto-generated method stub

    }

    @Override
    public List<User> getUsers(int userId) throws InvalidArgumentException {
        Data data = new UserData();
        List<Object> objects = data.fileReader(Util.projectDirectory());
        List<User> users = objects.stream().map(user -> (User) user).collect(Collectors.toList());

        return users;
    }

    @Override
    public User addFriend(int userId, int setUserId) throws InvalidArgumentException {

        User user = null;
        boolean flag = false;
        for (User us : getUsers(userId)) {
            if (userId == us.getId()) {
                user = us;
                flag = true;
            }
        }
        if (flag) {
            dataFriend.fileWriter(Util.projectDirectory(), user);
        }
        return user;

    }

    @Override
    public List<User> getFriends(int userId) throws InvalidArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User checkUser(User user) throws InvalidArgumentException, MyExceptions {
        List<Object> objects = data.fileReader(Util.projectDirectory());
        User result = null;
        boolean flag = false;
        for (Object o : objects) {
            User user1 = new User();
            user1 = ((User) o);
            if (user.getName().equals(((User) o).getName()) && user.getPassword().equals(((User) o).getPassword())) {
                result = ((User) o);
                flag = true;

            }
        }
        if (!flag) {
            throw new MyExceptions("User doesn't exist");
        }
        return result;
    }

}
