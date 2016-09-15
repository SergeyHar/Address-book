package test.java;

import com.model.User;
import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.model.util.InvalidArgumentException;
import com.model.util.PropertiesMessage;
import com.model.util.Util;
import com.repository.sql.PhoneNumbersDb;
import com.repository.sql.UsersDb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Test {
    public static void main(String[] args) {
PhoneNumbersDb   numbersDb =PhoneNumbersDb.getInstance();
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        try {
            System.out.println("iii");
//            System.out.println(numbersDb.getPhoneNumbers(5) );
            phoneNumbers = numbersDb.getPhoneNumbers(18);
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

/*
            //old version
            for (PhoneNumber phoneNumber : phoneNumbers) {
                Util.printMessage(phoneNumber.toString());
            }
*/
//            lambda expression
        phoneNumbers.forEach(phoneNumber -> Util.printMessage(phoneNumber.toString()));

       /* PropertiesMessage properties =new PropertiesMessage();
//        System.out.println(properties.getDbMessage("tbUser"));

        PhoneNumber phoneNumber = new PhoneNumber();
        PhoneNumbersDb phoneNumbersDb = new PhoneNumbersDb();
        phoneNumber.setUserId(3);


        phoneNumber.setType(PhoneType.WORK);
        phoneNumber.setNumber("13541");


        try {

            System.out.println(phoneNumbersDb.getPhoneNumber(3, phoneNumber));
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

      /*  UsersDb usersDb = UsersDb.getInstance();
        try {
            ;
            Util.printMessage(String.valueOf(usersDb.getUser("hayk").getId()));
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PropertiesMessage prop = new PropertiesMessage();
        System.out.println(prop.getDbMessage("dataBaseLogIn"));*/
   /*  //add metode
        UsersDb usersDb = UsersDb.getInstance();
        User user=new User("manvel12", "354sdad");

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

//        try {
//            UserDbQuery userDbRepository = UserDbQuery.getInstance();
//            userDbRepository.update("sada");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}
