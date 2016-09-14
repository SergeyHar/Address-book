package com.controller;

import com.model.User;
import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.model.util.InvalidArgumentException;
import com.model.util.Util;
import com.model.util.Validate;
import com.repository.svc.PhoneNumberRepository;
import com.repository.svc.PhoneNumberRepositoryInt;
import com.repository.svc.UserRepository;
import com.repository.svc.UserRepositoryInt;
import com.repository.sql.interfaces.UserDbInt;
import com.repository.sql.UsersDb;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller implements ControllerInt {
    private Scanner scanner = new Scanner(System.in);
    private String commandLine;

    private UserRepositoryInt repository = new UserRepository();
    private PhoneNumberRepositoryInt phoneNumberRepository = new PhoneNumberRepository();

    private UserDbInt userDb = UsersDb.getInstance();

    @Override
    public String inputCommand() {
        commandLine = scanner.nextLine();
        return commandLine;
    }

    @Override
    public void start() {

        switch (inputCommand()) {
            case "Sign Up":
                try {
                    signUp();
                } catch (Exception e) {
                    signUp();
                    e.printStackTrace();
                }
                Util.printMessage("Please write down one of this commands \"Sign In\" or \"Sign Up\"");
                start();
                break;
            case "Sign In":
                signIn();
                Util.printMessage("Now you can write down one of this commands \"Add Tel. Numb\" or \"Show Tel. Numbers\"");
                start();
                break;
            case "Edit profile":
                editProfile();
                Util.printMessage("Please write new command");
                start();
                break;
            case "Add Tel. Numb":
                addTel();
                Util.printMessage("You have successfully added your number. If you want to add one more please write \"Add Tel. Numb\". If you want to see your numbers list please write \"Show Tel. Numbers\"");
                start();
                break;
            case "Edit Tel. Numb":
                editTel();
                Util.printMessage("Please write new command");
                start();
                break;
            case "Show Tel. Numbers":
                showTel();
                Util.printMessage("Please write new command");
                start();
                break;
            case "Add Friend":
                addFriend();
                Util.printMessage("Please write new command");
                start();
                break;
            case "Show Friend":
                showFriends();
                Util.printMessage("Please write new command");
                start();
                break;
            case "Delete Friend":
                deleteFriend();
                Util.printMessage("Please write new command");
                start();
                break;
            case "Help":
                help();
                System.out.println("help");
                start();
                break;
            case "Exit":
                exit();
                break;
            default:
                Util.printMessage("Pleas correct input command");
                start();
                break;
        }
    }

    @Override
    public void editProfile() {
        String name;
        String password;
        User user = new User();
        Util.printMessage("Input new name");
        name = inputCommand();
        Util.printMessage("Input new password");
        password = inputCommand();
        user.setName(name);
        user.setPassword(password);
        try {
            repository.editUser(user);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }

    }

    public void signUp() {
        Util.printMessage("Please provide your username:");
        String name = Validate.notNull(inputCommand());
        Util.printMessage("Please provide your password:");
        String pass = Validate.notNull(inputCommand());

        User user = new User(name, pass);

        try {
            userDb.addUser(user);
//            repository.addUser(user);
        } catch (InvalidArgumentException e) {
            Util.printMessage(e);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Util.printMessage("Dear " + user.getName());
        Util.printMessage("You have successfully created user. Please write down one of this commands \"Sign In\" or \"Sign Up\"");
    }

    public void signIn() {
        String name;
        String pass;
        Util.printMessage("Please write login");
        name = inputCommand();
        Util.printMessage("Please write password");
        pass = inputCommand();
        if (name.equals("Exit") || pass.equals("Exit")) {
            exit();
        } else if (!name.equals("") && !pass.equals("")) {
            User user = new User();
            user.setName(name);
            user.setPassword(pass);
            try {
                Util.loginUser = userDb.getUser(user.getName());
//                Util.loginUser = repository.existingUserCheckup(user);
            } catch (InvalidArgumentException invalidArgumentException) {
                Util.printMessage(invalidArgumentException);
                signIn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Util.printMessage("Please correct login and password");
            signIn();
        }

    }

    public void addFriend() {
        String friendName;
        Util.printMessage("Please provide your friend username");
        friendName = inputCommand();
//        User user = null;
//        boolean flag = false;
        try {
            User user = userDb.getUser(friendName);
            userDb.addFriend(Util.loginUser.getId(), user.getId());

//            for (User user1 : repository.getUsers()) {
//                if (user1.getName().equals(friendName)) {
//                    Util.printMessage(user1.getName() + "  " + user1.getId());
//                    user = user1;
//                    flag = true;
//                }
//            }
//            if (flag) {
//                repository.addFriend(Util.loginUser.getId(), user.getId());
//                Util.printMessage(Util.loginUser.getId() + "");
//                Util.printMessage(user.getName() + " " + user.getId());
//                Util.printMessage("Thank you. Now " + friendName + " can has access to your address book");
//            } else {
//                throw new InvalidArgumentException("Please correct your friend name");
//            }

        } catch (InvalidArgumentException invalidArgumentException) {
            Util.printMessage(invalidArgumentException);
            addFriend();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFriends() {
        try {
            Util.printMessage("Friends  ");
//            for (User user : repository.getFriends(Util.loginUser.getId())) {
            for (User user : userDb.getFriends(Util.loginUser.getId())) {
                Util.printMessage(", " + user.getName());
            }

        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteFriend() {
        Util.printMessage("Write friend name if you wont delete");
        String deleteFriend = inputCommand();
        try {
            User friend = userDb.getUser(deleteFriend);
            userDb.deleteFriend(Util.loginUser.getId(), friend.getId());
//            repository.deleteFriend(Util.loginUser.getId(), deleteFriendId);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addTel() {
        PhoneType phoneType;
        int number;
        Util.printMessage("Please write phone type \"1\"=MOBILE, \"2\"=HOME, \"3\"=WORK");
        phoneType = Util.checkType(Integer.parseInt(inputCommand()));
        Util.printMessage("Please write number");

        try {
            number = Integer.parseInt(inputCommand());
            PhoneNumber phoneNumber = new PhoneNumber(Util.loginUser.getId(), phoneType, number);
            phoneNumberRepository.addNumber(Util.loginUser.getId(), phoneNumber);
        } catch (InvalidArgumentException e) {
            Util.printMessage(e);
        } catch (NumberFormatException nE) {
            Util.printMessage(String.valueOf(nE));
            addTel();
        }

    }

    @Override
    public void editTel() {
        //edit
    }

    public void showTel() {
        try {
            for (PhoneNumber phoneNumber : phoneNumberRepository.getNumbers(Util.loginUser.getId())) {
                for (User friend : repository.getFriends(Util.loginUser.getId())) {
                    if (phoneNumber.getUserId() == Util.loginUser.getId() || friend.getId() == phoneNumber.getUserId()) {
                        Util.printMessage(phoneNumber.toString());
                    }
                }
            }
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }

    public void help() {
        Util.printMessage("\"Sign In\", \"Sign Up\", \"Edit profile\", \"Add Tel. Numb\", \"Show Tel. Numbers\", \"Add Friend\", \"Exit\"");
    }

    @Override
    public void exit() {
        Util.printMessage("Good bye");
        System.exit(0);
    }
}
