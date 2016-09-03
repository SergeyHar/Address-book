package com.repository;

import com.data.Data;
import com.data.FriendData;
import com.data.UserData;
import com.model.User;
import com.model.util.MyExceptions;
import com.model.util.Util;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    }

    @Override
    public List<User> getUsers(int userId) throws InvalidArgumentException {
        Data data = new UserData();
        List<Object> objects = data.fileReader(Util.projectDirectory());
//        List<User> users = objects.stream().map(user -> (User) user).collect(Collectors.toList());
        List<User> users = new ArrayList<>();
        for (Object o : objects) {
            users.add((User) o);
        }

        return users;
    }

    @Override
    public User addFriend(int userId, int setUserId) throws InvalidArgumentException {

        User user = null;
        boolean flag = false;
        for (User us : getUsers(userId)) {
            if (setUserId == us.getId()) {
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
        List<Object> objects = dataFriend.fileReader(Util.projectDirectory());
        List<HashMap<Integer, Integer>> friendsMap = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<User> usersList = getUsers(Util.loginUser.getId());
        List<Integer> friendsId = new ArrayList<>();
        for (Object o : objects) {
//            System.out.println(o.toString());

            HashMap<Integer, Integer> checkFriend = (HashMap<Integer, Integer>) o;
            if (checkFriend.get(userId) != null) {
                for (User user : usersList) {
                    if (user.getId() == ((HashMap<Integer, Integer>) o).get(userId)) {
                        users.add(user);
                    }
                }
                friendsId.add(((HashMap<Integer, Integer>) o).get(userId));
            }
        }

        return users;
    }

    @Override
    public void deleteFriend(int friendId) throws InvalidArgumentException {
        getFriends(Util.loginUser.getId());



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
