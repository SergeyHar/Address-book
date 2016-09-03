package com.controller;

import com.model.User;
import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.model.util.MyExceptions;
import com.model.util.Util;
import com.model.util.Validate;
import com.repository.PhoneNumberRepository;
import com.repository.UserRepository;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    String commandLine;

    UserRepository repository = new UserRepository();
    PhoneNumberRepository phoneNumberReposytory = new PhoneNumberRepository();


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
                    signUp();
                    e.printStackTrace();
                }
                System.out.println("Please write down one of this commands \"Sign In\" or \"Sign Up\"");
                inputValue();
                break;
            case "Sign In":
                signIn();
                System.out.println("Now you can write down one of this commands \"Add Tel. Numb\" or \"Show Tel. Numbers\"'");
                inputValue();
                break;
            case "Add Tel. Numb":
                addTel();
                System.out.println("You have successfully added your number. If you want to add one more please write \"Add Tel. Numb\". If you want to see your numbers list please write \"Show Tel. Numbers\"");
                inputValue();
                break;
            case "Show Tel. Numbers":
                showTel();
                System.out.println("Please write new command");
                inputValue();
                break;

            case "Add Friend":
                addFriend();
                System.out.println("Please write new command");
                inputValue();
                break;
            case "Show Friend":
                showFriends();
                System.out.println("Please write new command");
                inputValue();
                break;
            case "Delete Friend":
                deleteFriend();
                System.out.println("Please write new command");
                inputValue();
                break;
            case "Help":
                help();
                System.out.println("help");
                inputValue();
                break;

            default:
                System.out.println("Pleas correct input command");
                inputValue();
                break;
        }
    }

    private void showFriends() {


        try {
            System.out.println("Friends  ");
            for (User user : repository.getFriends(Util.loginUser.getId())) {
                System.out.printf(", " + user.getName());
            }

        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }

    }

    private void deleteFriend() {
        System.out.println("Write friend name if you wont delete");
        String deleteFriend = inputCommand();
        int deleteFriendId=0;
        try {
            repository.deleteFriend(deleteFriendId);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }

    }

    private void addFriend() {
        String friendName;
        System.out.println("Please provide your friend username");
        friendName = inputCommand();
        User user = null;
        boolean flag = false;
        try {
            for (User user1 : repository.getUsers(Util.loginUser.getId())) {
                if (user1.getName().equals(friendName)) {
                    System.out.println(user1.getName() + "  " + user1.getId());
                    user = user1;
                    flag = true;
                }
            }
            if (flag) {
                repository.addFriend(Util.loginUser.getId(), user.getId());
                System.out.println(Util.loginUser.getId());
                System.out.println(user.getName() + " " + user.getId());
                System.out.println("Thank you. Now " + friendName + " can has access to your address book");
            } else {
                throw new MyExceptions("Please correct your friend name");
            }

        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (MyExceptions myExceptions) {
            System.out.println(myExceptions);
            addFriend();
        }


    }

    private void showTel() {
        try {
            for (PhoneNumber phoneNumber : phoneNumberReposytory.showNumbers(Util.loginUser.getId())) {
                for (User friend : repository.getFriends(Util.loginUser.getId())) {
                    if (phoneNumber.getUserId() == Util.loginUser.getId() || friend.getId() == phoneNumber.getUserId()) {
                        System.out.println(phoneNumber.toString());
                    }
                }
            }
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }

    private void addTel() {
        PhoneType phoneType;
        int number = 0;
        System.out.println("Please write phone type \"1\"=MOBILE, \"2\"=HOME, \"3\"=WORK");
        phoneType = Util.checkType(Integer.parseInt(inputCommand()));
        System.out.println("Please write number");
        try {
            number = Integer.parseInt(inputCommand());
        } catch (NumberFormatException nE) {
            System.out.println(nE);
            addTel();
        }
        try {
            phoneNumberReposytory.addNumber(Util.loginUser.getId(), phoneType, number);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }

    }

    private void help() {
        System.out.println("\"Sign In\", \"Sign Up\", \"Add Tel. Numb\", \"Show Tel. Numbers\", \"Add Friend\"");
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
        System.out.println("Dear " + user.getName());
        System.out.println(
                "You have successfully created user. Please write down one of this commands \"Sign In\" or \"Sign Up\"");

    }

    public void signIn() {
        String name;
        String pass;

        System.out.println("Please write login");
        name = inputCommand();
        System.out.println("Please write password");
        pass = inputCommand();

        if (name != "" && pass != "") {
            User user = new User();
            user.setName(name);
            user.setPassword(pass);
            try {
                Util.loginUser = repository.checkUser(user);
            } catch (InvalidArgumentException e) {
                System.out.println(e);
            } catch (MyExceptions myExceptions) {
                System.out.println(myExceptions);
                signIn();
            }
        } else {
            System.out.println("Please correct login and password");
            signIn();
        }

    }
}
