package com.repository.sql;

import com.model.phonenumber.PhoneNumber;
import com.model.util.InvalidArgumentException;
import com.model.util.PropertiesMessage;
import com.repository.sql.implementation.PhoneNumberDbQuery;
import com.repository.sql.interfaces.PhoneNumbersRepositorySqlInt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhoneNumbersDb implements PhoneNumbersRepositorySqlInt {
    private static PhoneNumbersDb phoneNumbersDb;
    private PropertiesMessage properties = new PropertiesMessage();
    private final String TABLE_USERS = properties.getDbMessage("tbUser");
    private final String COLUMNS_USERS_ID = properties.getDbMessage("userId");
    private final String COLUMNS_USERS_NAME = properties.getDbMessage("userName");
    private final String COLUMNS_USERS_PASSWORD = properties.getDbMessage("userPassword");

    private final String TABLE_TEL_NUMBERS = properties.getDbMessage("tbNumbers");
    private final String COLUMNS_TEL_NUMBERS_ID = properties.getDbMessage("numberId");
    private final String COLUMNS_TEL_NUMBERS_USER_ID = properties.getDbMessage("numberUserId");
    private final String COLUMNS_TEL_NUMBERS_TYPE = properties.getDbMessage("numberType");
    private final String COLUMNS_TEL_NUMBERS_NUMBER = properties.getDbMessage("number");

    public PhoneNumbersDb() {
    }

    public static PhoneNumbersDb getInstance() {
        if (phoneNumbersDb == null) phoneNumbersDb = new PhoneNumbersDb();
        return phoneNumbersDb;

    }

    PhoneNumberDbQuery db = PhoneNumberDbQuery.getInstance();

    @Override
    public PhoneNumber addPhoneNumber(int userId, PhoneNumber phoneNumber) throws InvalidArgumentException, SQLException {
        PhoneNumber newPhoneNumber = new PhoneNumber();

        db.insert("INSERT INTO " + TABLE_TEL_NUMBERS + " (" + COLUMNS_TEL_NUMBERS_USER_ID + "," + COLUMNS_TEL_NUMBERS_TYPE + "," + COLUMNS_TEL_NUMBERS_NUMBER + ") VALUE (" + userId + "," + phoneNumber.getType() + ", " + phoneNumber.getNumber() + ")");
        newPhoneNumber = PhoneNumbersDb.getInstance().getPhoneNumber(userId, phoneNumber);

        return newPhoneNumber;
    }


    @Override
    public PhoneNumber editPhoneNumber(int userId, PhoneNumber phoneNumber, PhoneNumber newPhoneNumber) throws InvalidArgumentException, SQLException {

        db.update("UPDATE " + TABLE_TEL_NUMBERS + " SET " + COLUMNS_TEL_NUMBERS_TYPE + " = " + newPhoneNumber.getType() + " AND " + COLUMNS_TEL_NUMBERS_NUMBER + " = " + newPhoneNumber.getNumber() + " WHERE " + COLUMNS_TEL_NUMBERS_USER_ID + " = " + userId + " AND " + COLUMNS_TEL_NUMBERS_TYPE + " = " + phoneNumber.getType() + " AND " + COLUMNS_TEL_NUMBERS_NUMBER + " = " + phoneNumber.getNumber());
        newPhoneNumber = PhoneNumbersDb.getInstance().getPhoneNumber(userId, phoneNumber);

        return newPhoneNumber;
    }

    @Override
    public void deletePhoneNumber(int userId, PhoneNumber phoneNumber) throws InvalidArgumentException, SQLException {
        db.delete("DELETE FROM" + TABLE_TEL_NUMBERS + "WHERE" + COLUMNS_TEL_NUMBERS_USER_ID + " = " + userId + " AND " + COLUMNS_TEL_NUMBERS_TYPE + " = " + phoneNumber.getType() + " AND " + COLUMNS_TEL_NUMBERS_NUMBER + " = " + phoneNumber.getNumber());
    }

    @Override
    public PhoneNumber getPhoneNumber(int userId, PhoneNumber phoneNumber) throws InvalidArgumentException, SQLException {
        List<PhoneNumber> newPhoneNumber = new ArrayList<>();

        newPhoneNumber = db.select("SELECT * FROM " + TABLE_TEL_NUMBERS + " WHERE " + COLUMNS_TEL_NUMBERS_USER_ID + " = " + userId + " AND " + COLUMNS_TEL_NUMBERS_TYPE + " = \"" + phoneNumber.getType() + "\" AND " + COLUMNS_TEL_NUMBERS_NUMBER + " = \"" + phoneNumber.getNumber() + "\"");
        return newPhoneNumber.get(0);
    }

    @Override
    public List<PhoneNumber> getPhoneNumbers(int userId) throws InvalidArgumentException, SQLException , NullPointerException{
        System.out.println("test");

        List<PhoneNumber> newPhoneNumber ;
        newPhoneNumber = db.select("SELECT * FROM " + TABLE_TEL_NUMBERS + " WHERE " + COLUMNS_TEL_NUMBERS_USER_ID + " = " + userId);
        System.out.println(newPhoneNumber.size());

        return newPhoneNumber;
    }
}
