package com.data;

import java.util.List;

import com.model.User;

public interface Data {
	public void fileWriter(String path, User user);
	public List<Object> fileReader(String path);
	

}
