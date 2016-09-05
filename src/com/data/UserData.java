package com.data;

import com.model.User;
import com.model.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Data {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,name,password";
    private static final String FILE_NAME = "/user.csv";


    @Override
    public void fileWriter(String path, Object o) {

        FileWriter fileWriter = null;
        BufferedReader fileReader = null;

        try {
            fileWriter = new FileWriter(path + FILE_NAME, true);
            fileReader = new BufferedReader(new FileReader(path + FILE_NAME));

            if (fileReader.readLine() == null) {
                fileWriter.append(FILE_HEADER.toString());
                fileWriter.append(NEW_LINE_SEPARATOR.toString());
            }
            fileWriter.append(String.valueOf(((User) o).getId()));
            fileWriter.append(COMMA_DELIMITER.toString());
            fileWriter.append(String.valueOf(((User) o).getName()));
            fileWriter.append(COMMA_DELIMITER.toString());
            fileWriter.append(String.valueOf(((User) o).getPassword()));
            fileWriter.append(NEW_LINE_SEPARATOR.toString());


        } catch (Exception e) {
            Util.printMessage("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e) {
                Util.printMessage("Error while flushing/closing fileWriter !!!");
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
            final int USER_ID_IDX = 0;
            final int USER_NAME_IDX = 1;
            final int USER_PASSWORD_IDX = 2;

            List<Object> users = new ArrayList<>();

            String line = "";
            // Create the file reader
            fileReader = new BufferedReader(new FileReader(path + FILE_NAME));

            // Read the CSV file header to skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {

                String[] tokens = line.split(COMMA_DELIMITER);

                if (tokens.length > 0) {
                    User user = new User(tokens[USER_PASSWORD_IDX]);
                    user.setId(Integer.parseInt(tokens[USER_ID_IDX]));
                    user.setName(tokens[USER_NAME_IDX]);
                    users.add(user);
                }

            }
            result = users;

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
