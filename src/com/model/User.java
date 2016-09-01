package com.model;

import java.util.List;

import com.model.phonenumber.Number;
import com.model.util.Validate;

public class User {
	private String name;
	private String password;
	private int id;
	private static int next_id = 0;
	private List<Number> phoneNumber;
	private List<User> friend;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Validate.md5(password);
	}

	public int getId() {
		return id;
	}

	public static void reset_counter(int n) // use with care!
	{
		User.next_id = n;
	}

	public List<Number> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<Number> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<User> getFriend() {
		return friend;
	}

	public void setFriend(List<User> friend) {
		this.friend = friend;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = Validate.md5(password);
		this.id = ++User.next_id;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
