package com.repository;

import java.util.List;

import com.controller.User;
import com.data.UserData;

public class UserRepository implements UserRepositoryInterface {

	@Override
	public void addUser(User user) {

		UserData data = new UserData();
		String path = "";
		data.fileWriter(path + "user.csv", user );
	}

	@Override
	public User editUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delateUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
