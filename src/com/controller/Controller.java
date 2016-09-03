package com.controller;

import java.util.Scanner;

import com.model.User;
import com.model.util.Validate;
import com.repository.UserRepository;
import com.sun.javaws.exceptions.InvalidArgumentException;

public class Controller {
	Scanner scanner = new Scanner(System.in);
	String commandLine;

	UserRepository repository = new UserRepository();


	public String inputCommand() {
		commandLine = scanner.nextLine();
		return commandLine;

	}

	public void inputValue() {

		switch (inputCommand()) {
		case "Sign Up":
			try {
				signUp();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Sign In":

			signIn();
			break;
		case "Help":
			System.out.println("help");

			break;
		
		default:
			System.out.println("sdfgdsfsf");

			break;
		}
	}

	public void signUp() {
		System.out.println("Please provide your username:");
		String name = Validate.notNull(inputCommand());
		System.out.println("Please provide your password:");
		String pass = Validate.notNull(inputCommand());

		User user = new User(name, pass);

		try {
			repository.addUser(user);
		} catch (InvalidArgumentException e) {
			System.out.println("esim");
			e.printStackTrace();
		}
		System.out.println("Deare " + user.getName());
		System.out.println(
				"You have successfully created user. Please write down one of this commands \"Sign In\" or \"Sign Up\"");

	}

	public void signIn() {

	}
}