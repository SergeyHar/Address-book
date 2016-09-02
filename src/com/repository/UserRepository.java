package com.repository;

import java.util.List;

import com.data.UserData;
import com.model.User;
import com.sun.javaws.exceptions.InvalidArgumentException;

public class UserRepository implements UserRepositoryInterface {

	@Override
	public void addUser(User user)throws InvalidArgumentException {

		UserData data = new UserData();
		String path = "";
		data.fileWriter(path + "user.csv", user );
	}

	@Override
	public User editUser(User user) throws InvalidArgumentException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delateUser(int userId) throws InvalidArgumentException{
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers(int userId) throws InvalidArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFriend(int userId, int setUserId)throws InvalidArgumentException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> getFriends(int userId) throws InvalidArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
