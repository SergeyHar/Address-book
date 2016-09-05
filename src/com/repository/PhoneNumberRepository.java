package com.repository;

import com.data.Data;
import com.data.PhoneNumberData;
import com.model.phonenumber.PhoneNumber;
import com.model.util.InvalidArgumentException;
import com.model.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sergo on 03-Sep-16.
 */
public class PhoneNumberRepository implements PhoneNumberRepositoryInt {
    //Singleton Design Pattern, not used in my program :)
    /*  private static PhoneNumberRepository repository = null;
    private PhoneNumberRepository() {
    }
    public static PhoneNumberRepository getnumberRepository() {
        if (repository == null) {
            repository = new PhoneNumberRepository();
        }
        return repository;
    }*/


    Data phoneNumberData = new PhoneNumberData();

    @Override
    public PhoneNumber addNumber(int userId, PhoneNumber phoneNumber) throws InvalidArgumentException {

        phoneNumberData.fileWriter(Util.projectDirectory(), phoneNumber);

        return phoneNumber;
    }

    @Override
    public List<PhoneNumber> getNumbers(int userId) throws InvalidArgumentException {
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        List<Object> dataNumbers = phoneNumberData.fileReader(Util.projectDirectory());


        phoneNumbers.addAll(dataNumbers.stream().map(o -> ((PhoneNumber) o)).collect(Collectors.toList()));
        return phoneNumbers;
    }
}
