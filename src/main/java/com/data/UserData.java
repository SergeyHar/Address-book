package com.data;

import com.model.User;
import com.model.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Data<User> {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,name,password";
    private static final String FILE_NAME = "user.csv";

    private static String filePath(String path, String fileName) {
        String result;
        if (!path.equals("")) {
            result = path + "/" + fileName;
        } else {
            result = fileName;
        }
        return result;
    }


    @Override
    public void fileWriter(String path, User user) {
        FileWriter fileWriter = null;
        BufferedReader fileReader;

        try {
            fileWriter = new FileWriter(UserData.filePath(path, FILE_NAME), true);
            fileReader = new BufferedReader(new FileReader(UserData.filePath(path, FILE_NAME)));

            if (fileReader.readLine() == null) {
                fileWriter.append(FILE_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.append(String.valueOf(user.getId()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(user.getName()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(user.getPassword()));
            fileWriter.append(NEW_LINE_SEPARATOR);


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
    public void removeFileArgument(String path, User user) {

    }

    @Override
    public List<User> fileReader(String path) {
        BufferedReader fileReader;
        List<User> result = null;

        try {
            final int USER_ID_IDX = 0;
            final int USER_NAME_IDX = 1;
            final int USER_PASSWORD_IDX = 2;

            List<User> users = new ArrayList<>();

            String line;
            // Create the file reader
            fileReader = new BufferedReader(new FileReader(UserData.filePath(path, FILE_NAME)));

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


    @Override
    public void clearingFile(String path) {
        File outputFile = new File(UserData.filePath(path, FILE_NAME));
        try {
            FileWriter fw = new FileWriter(outputFile, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
