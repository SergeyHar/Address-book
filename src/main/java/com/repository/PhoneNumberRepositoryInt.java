package com.repository;

import com.model.phonenumber.PhoneNumber;
import com.model.util.InvalidArgumentException;

import java.util.List;

/**
 * Created by Sergo on 03-Sep-16.
 */
public interface PhoneNumberRepositoryInt {

    PhoneNumber addNumber(int userId, PhoneNumber phoneNumber)throws InvalidArgumentException, InvalidArgumentException;
    List<PhoneNumber> getNumbers(int userId)throws InvalidArgumentException;

}
