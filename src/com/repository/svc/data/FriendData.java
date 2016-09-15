package com.repository.svc.data;

import com.model.User;
import com.model.util.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FriendData implements Data<User> {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,userId";
    private static final String FILE_NAME = "friends.csv";

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
            fileWriter = new FileWriter(FriendData.filePath(path, FILE_NAME), true);
            fileReader = new BufferedReader(new FileReader(FriendData.filePath(path, FILE_NAME)));

            if (fileReader.readLine() == null) {
                fileWriter.append(FILE_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.append(String.valueOf(Util.loginUser.getId()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(user.getId()));
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (Exception e) {
            Util.printMessage("Error in friendsFileWriter !!!");
//            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();

            } catch (IOException e) {
                Util.printMessage("Error while flushing/closing friendsFileWriter !!!");
//                e.printStackTrace();
            }
        }

    }

    @Override
    public void removeFileArgument(String path, User user) {

    }

    @Override
    public List<User> fileReader(String path) {
        BufferedReader fileReader ;
        List<User> result = null;

        try {

            final int ID_IDX = 0;
            final int FRIEND_ID_IDX = 1;
            List<User> friendMapList = new ArrayList<>();

            String line;
            // Create the file reader
            fileReader = new BufferedReader(new FileReader(FriendData.filePath(path, FILE_NAME)));

            // Read the CSV file header to skip it
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {

                String[] tokens = line.split(COMMA_DELIMITER);

                if (tokens.length > 0) {
                    FriendMap friendMap = new FriendMap(Integer.parseInt(tokens[ID_IDX]),Integer.parseInt(tokens[FRIEND_ID_IDX]));
                    friendMapList.add(friendMap);
                }
            }
            result = friendMapList;

        } catch (FileNotFoundException e) {
            Util.printMessage("Error in CsvFileReader !!!");
//            e.printStackTrace();
        } catch (IOException e) {
            Util.printMessage("Error while closing fileReader !!!");
//            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void clearingFile(String path) {
        File outputFile = new File(FriendData.filePath(path, FILE_NAME));
        try {
            FileWriter fw = new FileWriter(outputFile, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
