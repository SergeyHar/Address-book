package com;

import java.util.Scanner;

import com.repository.UserRepository;

public class Controller {
	Scanner scanner = new Scanner(System.in);
	String commandLine;

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

		UserRepository repository = new UserRepository();
		repository.addUser(user);
		System.out.println("Deare " + user.getName());
		System.out.println(
				"You have successfully created user. Please write down one of this commands \"Sign In\" or \"Sign Up\"");

	}

	public void signIn() {

	}
}
