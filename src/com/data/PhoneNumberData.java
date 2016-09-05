package com.data;

import com.model.phonenumber.PhoneNumber;
import com.model.phonenumber.PhoneType;
import com.model.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberData implements Data {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,userId,type,number";
    private static final String FILE_NAME = "/telAddress.csv";

    @Override
    public void fileWriter(String path, Object object) {
        FileWriter fileWriter = null;
        BufferedReader fileReader = null;

        try {
            fileWriter = new FileWriter(path + FILE_NAME, true);
            fileReader = new BufferedReader(new FileReader(path + FILE_NAME));

            if (fileReader.readLine() == null) {
                fileWriter.append(FILE_HEADER.toString());
                fileWriter.append(NEW_LINE_SEPARATOR.toString());
            }
            fileWriter.append(String.valueOf(((PhoneNumber) object).getId()));
            fileWriter.append(COMMA_DELIMITER.toString());
            fileWriter.append(String.valueOf(Util.loginUser.getId()));
            fileWriter.append(COMMA_DELIMITER.toString());
            fileWriter.append(String.valueOf(((PhoneNumber) object).getType()));
            fileWriter.append(COMMA_DELIMITER.toString());
            fileWriter.append(String.valueOf(((PhoneNumber) object).getNumber()));
            fileWriter.append(NEW_LINE_SEPARATOR.toString());


        } catch (Exception e) {
            Util.printMessage("Error in NumberFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e) {
                Util.printMessage("Error while flushing/closing numberFileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void removeFileArgument(String path, Object object) {

    }

    @Override
    public List<Object> fileReader(String path) {

        BufferedReader fileReader = null;
        List<Object> result = null;

        try {
            final int PHONE_ID_IDX = 0;
            final int USER_ID_IDX = 1;
            final int PHONE_TYPE_IDX = 2;
            final int PHONE_NUMBER_IDX = 3;

            List<Object> numbers = new ArrayList<>();

            String line = "";
            // Create the file reader
            fileReader = new BufferedReader(new FileReader(path + FILE_NAME));

            // Read the CSV file header to skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {

                String[] tokens = line.split(COMMA_DELIMITER);

                if (tokens.length > 0) {
                    PhoneNumber phoneNumber = new PhoneNumber();
                    phoneNumber.setId(Integer.parseInt(tokens[PHONE_ID_IDX]));
                    phoneNumber.setUserId(Integer.parseInt(tokens[USER_ID_IDX]));
                    phoneNumber.setType(PhoneType.valueOf(tokens[PHONE_TYPE_IDX]));
                    phoneNumber.setNumber(Integer.parseInt(tokens[PHONE_NUMBER_IDX]));
                    numbers.add(phoneNumber);
                }
            }
            result = numbers;

        } catch (FileNotFoundException e) {
            Util.printMessage("Error in CsvFileReader !!!");
            e.printStackTrace();
        } catch (IOException e) {
            Util.printMessage("Error while closing fileReader !!!");
            e.printStackTrace();
        }
        return result;

    }


}
