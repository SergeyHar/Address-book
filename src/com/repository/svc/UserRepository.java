package com.repository.svc;

import com.data.Data;
import com.data.FriendData;
import com.data.UserData;
import com.model.User;
import com.model.util.InvalidArgumentException;
import com.model.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository implements UserRepositoryInt {
    private Data data = new UserData();
    private Data dataFriend = new FriendData();


    @Override
    public void addUser(User user) throws InvalidArgumentException {
        data.fileWriter(Util.projectDirectory(), user);
    }

    @Override
    public User editUser(User user) throws InvalidArgumentException {
        List<User> newUsers = new ArrayList<>();

        for (Object getUserValue : data.fileReader(Util.projectDirectory())) {
            if (((User) getUserValue).getId() == Util.loginUser.getId()) {
                Util.loginUser = user;
                Util.loginUser.setId(((User) getUserValue).getId());
                newUsers.add(Util.loginUser);
            } else {
                newUsers.add(((User) getUserValue));
            }
        }
        data.clearingFile(Util.projectDirectory());
        for (User writeUser : newUsers) {
            data.fileWriter(Util.projectDirectory(), writeUser);
        }

        return Util.loginUser;
    }

    @Override
    public void deleteUser(int userId) throws InvalidArgumentException {

    }

    @Override
    public List<User> getUsers() throws InvalidArgumentException {
        List<Object> objects = data.fileReader(Util.projectDirectory());
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
        for (User us : getUsers()) {
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
        List<User> usersList = getUsers();
        List<Integer> friendsId = new ArrayList<>();
        for (Object o : objects) {
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
    public void deleteFriend(int userId, int friendId) throws InvalidArgumentException {


        getFriends(Util.loginUser.getId());
    }

    @Override
    public User existingUserCheckup(User user) throws InvalidArgumentException {
        List<Object> objects = data.fileReader(Util.projectDirectory());
        User result = null;
        boolean flag = false;
        for (Object o : objects) {
            if (user.getName().equals(((User) o).getName()) && user.getPassword().equals(((User) o).getPassword())) {
                result = ((User) o);
                flag = true;
            }
        }
        if (!flag) {
            throw new InvalidArgumentException("User doesn't exist");
        }
        return result;
    }

}
