package com.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.controller.User;

public class UserData implements Data {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String FILE_HEADER = "id,name,password";

	@Override
	public void fileWriter(String path, User user) {

		FileWriter fileWriter = null;
		BufferedReader fileReader = null;

		try {
			fileWriter = new FileWriter(path, true);
			fileReader = new BufferedReader(new FileReader(path));

			if (fileReader.readLine() == null) {
				fileWriter.append(FILE_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR.toString());
			}
			User.reset_counter(0);
			// append Uesr
//			if()
			fileWriter.append(String.valueOf(user.getId()));
			fileWriter.append(COMMA_DELIMITER.toString());
			fileWriter.append(String.valueOf(user.getName()));
			fileWriter.append(COMMA_DELIMITER.toString());
			fileWriter.append(String.valueOf(user.getPassword()));

			fileWriter.append(NEW_LINE_SEPARATOR.toString());

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Object> fileReader(String path) {

		BufferedReader fileReader = null;

		try {
			final int USER_ID_IDX = 0;
			final int USER_NAME_IDX = 1;
			final int USER_PASSWORD_IDX = 2;

			List<Object> users = new ArrayList<>();
			
			String line = "";
			// Create the file reader
			fileReader = new BufferedReader(new FileReader(path));

			// Read the CSV file header to skip it
			fileReader.readLine();

			while ((line = fileReader.readLine()) != null) {

				String[] tokens = line.split(COMMA_DELIMITER);

				if (tokens.length > 0) {
					User user = new User(tokens[USER_NAME_IDX], tokens[USER_PASSWORD_IDX]);

					users.add(user);
				}

			}
//			for (Object user :  users) {
//				System.out.println(user.toString());
//			}
			return users;

		} catch (FileNotFoundException e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while closing fileReader !!!");
			e.printStackTrace();
		}
		return null;

	}

}
