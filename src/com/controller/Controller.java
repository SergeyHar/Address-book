package com.controller;

import com.model.User;
import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.model.util.InvalidArgumentException;
import com.model.util.PropertiesMessage;
import com.model.util.Util;
import com.model.util.Validate;
import com.repository.sql.PhoneNumbersDb;
import com.repository.sql.UsersDb;
import com.repository.sql.interfaces.UserRepositorySqlInt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Controller implements ControllerInt {
    private Scanner scanner = new Scanner(System.in);
    private String commandLine;

    private PropertiesMessage message = new PropertiesMessage();
    private UserRepositorySqlInt userDb = UsersDb.getInstance();
    private PhoneNumbersDb numbersDb = PhoneNumbersDb.getInstance();

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
            case "Delete profile":
                deleteProfile();
                Util.printMessage("Please write new command");
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
        Util.printMessage(message.getMessage("inputNewName"));
        name = inputCommand();
        Util.printMessage(message.getMessage("inputNewPassword"));
        password = inputCommand();
        user.setName(name);
        user.setPassword(password);
        try {
            Util.loginUser = userDb.editUser(Util.loginUser, user);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProfile() {
        String name;
        String password;
        User user = new User();
        Util.printMessage(message.getMessage("inputNewName"));
        name = inputCommand();
        Util.printMessage(message.getMessage("inputNewPassword"));
        password = inputCommand();
        user.setName(name);
        user.setPassword(password);
        try {
            userDb.deleteUser(userDb.getUser(name, password).getId());
        } catch (SQLException e) {
            Util.printMessage(message.getMessage("inputValueBroken"));
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        Util.printMessage(message.getMessage("inputName"));
        String name = Validate.notNull(inputCommand());
        Util.printMessage(message.getMessage("inputPassword"));
        String pass = Validate.notNull(inputCommand());

        User user = new User(name, pass);

        try {
            userDb.addUser(user);
        } catch (InvalidArgumentException e) {
            Util.printMessage(e);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Util.printMessage("Dear " + user.getName());
        Util.printMessage(message.getMessage("createdUser"));
    }

    public void signIn() {
        Util.printMessage(message.getMessage("inputName"));
        String name = inputCommand();
        Util.printMessage(message.getMessage("inputPassword"));
        String pass = inputCommand();

        if (name.equals("Exit") || pass.equals("Exit")) {
            exit();
        } else if (!name.equals("") && !pass.equals("")) {
            User user = new User();
            user.setName(name);
            user.setPassword(pass);
            try {
                Util.loginUser = userDb.getUser(user.getName());
            } catch (InvalidArgumentException invalidArgumentException) {
                Util.printMessage(invalidArgumentException);
                signIn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Util.printMessage(message.getMessage("inputValueBroken"));
            signIn();
        }

    }

    public void addFriend() {
        String friendName;
        Util.printMessage(message.getMessage("inputFriendName"));
        friendName = inputCommand();
        try {
            User user = userDb.getUser(friendName);
            userDb.addFriend(Util.loginUser.getId(), user.getId());

        } catch (InvalidArgumentException invalidArgumentException) {
            Util.printMessage(invalidArgumentException);
            addFriend();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFriends() {
        try {
            Util.printMessage(message.getMessage("friends"));
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
        Util.printMessage(message.getMessage("deleteFriend"));
        String deleteFriend = inputCommand();
        try {
            User friend = userDb.getUser(deleteFriend);
            userDb.deleteFriend(Util.loginUser.getId(), friend.getId());
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addTel() {
        PhoneType phoneType;
        String number;
        Util.printMessage(message.getMessage("inputPhoneType"));
        phoneType = Util.checkType(inputCommand());
        Util.printMessage(message.getMessage("inputNumber"));
        number = inputCommand();

        try {
            PhoneNumber phoneNumber = new PhoneNumber(Util.loginUser.getId(), phoneType, number);
            numbersDb.addPhoneNumber(Util.loginUser.getId(), phoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            Util.printMessage(e);
        } catch (NumberFormatException nE) {
            Util.printMessage(String.valueOf(nE));
            addTel();
        }
    }

    @Override
    public void editTel() {
        PhoneType phoneType;
        String number;

        Util.printMessage(message.getMessage("inputPhoneType"));
        phoneType = Util.checkType(inputCommand());
        Util.printMessage(message.getMessage("inputNumber"));
        number = inputCommand();

        PhoneNumber phoneNumber = new PhoneNumber(phoneType, number);

        Util.printMessage(message.getMessage("inputNewPhoneType"));
        phoneType = Util.checkType(inputCommand());
        Util.printMessage(message.getMessage("inputNewNumber"));
        number = inputCommand();

        PhoneNumber newPhoneNumber = new PhoneNumber(phoneType, number);

        try {
            numbersDb.editPhoneNumber(Util.loginUser.getId(), phoneNumber, newPhoneNumber);

        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showTel() {
        try {
            List<PhoneNumber> phoneNumbers = numbersDb.getPhoneNumbers(Util.loginUser.getId());

/*            //old version
            for (PhoneNumber phoneNumber : phoneNumbers) {
                Util.printMessage(phoneNumber.toString());
            }
*/
//            lambda expression
            phoneNumbers.forEach(phoneNumber -> Util.printMessage(phoneNumber.toString()));

        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void help() {
        Util.printMessage(message.getMessage("help"));
    }

    @Override
    public void exit() {
        Util.printMessage(message.getMessage("exit"));
        System.exit(0);
    }
}
