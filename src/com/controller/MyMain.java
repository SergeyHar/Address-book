package com.controller;

import com.data.UserData;

public class MyMain {
	public static void main(String[] args) {
		Controller c = new Controller();
		System.out.println("Please write down one of this commands \"Sign In\" or \"Sign Up\"");
		c.inputValue();
	}
}
