package com.repository;

import com.data.PhoneNumberData;
import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.model.util.Util;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergo on 03-Sep-16.
 */
public class PhoneNumberRepository implements PhoneNumberRepositoryInt {
    PhoneNumberData phoneNumberData = new PhoneNumberData();

    @Override
    public PhoneNumber addNumber(int userId, PhoneType type, int number) throws InvalidArgumentException {
        PhoneNumber phoneNumber = new PhoneNumber(userId, type, number);

        phoneNumberData.fileWriter(Util.projectDirectory(), phoneNumber);

        return phoneNumber;
    }

    @Override
    public List<PhoneNumber> showNumbers(int userId) throws InvalidArgumentException {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        List<Object> objects = phoneNumberData.fileReader(Util.projectDirectory());

        phoneNumbers.addAll(objects.stream().map(o -> ((PhoneNumber) o)).collect(Collectors.toList()));
        return phoneNumbers;
    }
}
