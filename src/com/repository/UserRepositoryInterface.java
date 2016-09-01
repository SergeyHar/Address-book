package com.repository;

import java.util.List;

import com.User;

public interface UserRepositoryInterface {
	public void addUser(User user);

	public User editUser(User user);

	public void delateUser(int userId);

	public List<User> getUsers(int userId);

}
