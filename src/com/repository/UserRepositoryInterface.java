package com.repository;

import java.util.List;

import com.model.User;

public interface UserRepositoryInterface {
	public void addUser(User user);

	public User editUser(User user);

	public void delateUser(int userId);

	public List<User> getUsers(int userId);
	
	public void addFriend(int userId, int setUserId);

}
