package com.model.util;

import com.controller.Controller;

public class Test {

    public static void main(String[] args) {
//        UserData d = new UserData();
//        User u1 = new User("Aram", "sadsa");
//        d.fileWriter("user.csv", u1);
//        User u2 = new User("karen", "sadsa");
//        User u3 = new User("Mark", "sadsa");
//
//        d.fileWriter("user.csv", u2);
//        d.fileWriter("user.csv", u3);
//
//        for (Object string : d.fileReader("user.csv")) {
//            User us = (User) string;
//            System.out.println(us.getId());
//        }
//        User u4 = new User("hayk", "sda5");
//        d.fileWriter("user.csv", u4);
//        u4 = (User) d.fileReader("user.csv").get(d.fileReader("user.csv").size() - 1);
//
//        System.out.println(u4.getId());

		Controller c = new Controller();
		System.out.println("Please write down one of this commands \"Sign In\" or \"Sign Up\"");
		c.inputValue();


	}

}
