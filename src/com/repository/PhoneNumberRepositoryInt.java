package com.repository;

import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.List;

/**
 * Created by Sergo on 03-Sep-16.
 */
public interface PhoneNumberRepositoryInt {

    PhoneNumber addNumber(int userId, PhoneType type, int number)throws InvalidArgumentException;
    List<PhoneNumber> showNumbers(int userId)throws InvalidArgumentException;

}
