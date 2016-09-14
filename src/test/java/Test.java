package test.java;

import com.repository.sql.implementation.UserDbQuery;
import com.repository.sql.UsersDb;

import java.sql.SQLException;


public class Test {
    public static void main(String[] args) {

        UsersDb usersDb = UsersDb.getInstance();

/*
     //add metode
        User user=new User("manvel", "354sdad");
        try {
            usersDb.addUser(user);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/

/*
//        add frined
        try {
            usersDb.addFriend(2, 5);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/

/*//        delete user

        try {
            usersDb.deleteUser(18);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

//        try {
//            System.out.println(usersDb.existByUsername("aram"));
//        } catch (InvalidArgumentException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            UserDbQuery userDbRepository = UserDbQuery.getInstance();
            userDbRepository.update("sada");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
