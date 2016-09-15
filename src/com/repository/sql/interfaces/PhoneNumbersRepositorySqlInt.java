package com.repository.sql.interfaces;


import com.model.phonenumber.PhoneNumber;
import com.model.util.InvalidArgumentException;

import java.sql.SQLException;
import java.util.List;

public interface PhoneNumbersRepositorySqlInt {

    PhoneNumber addPhoneNumber(int userId, PhoneNumber phoneNumber) throws InvalidArgumentException, SQLException;

    PhoneNumber editPhoneNumber(int userId, PhoneNumber phoneNumber, PhoneNumber newPhoneNumber) throws InvalidArgumentException, SQLException;

    void deletePhoneNumber(int userId, PhoneNumber phoneNumber) throws InvalidArgumentException, SQLException;

    PhoneNumber getPhoneNumber(int userId, PhoneNumber phoneNumber) throws InvalidArgumentException, SQLException;

    List<PhoneNumber> getPhoneNumbers(int userId) throws InvalidArgumentException, SQLException;


}
