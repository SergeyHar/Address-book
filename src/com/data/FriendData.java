package com.data;

import com.model.User;
import com.model.util.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FriendData implements Data{
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String FILE_HEADER = "id,userId";


	@Override
	public void fileWriter(String path, Object object) {
		FileWriter fileWriter = null;
		BufferedReader fileReader = null;

		try {
			fileWriter = new FileWriter(path+"friends.csv", true);
			fileReader = new BufferedReader(new FileReader(path+"friends.csv"));

			if (fileReader.readLine() == null) {
				fileWriter.append(FILE_HEADER.toString());
				fileWriter.append(NEW_LINE_SEPARATOR.toString());
			}
			fileWriter.append(String.valueOf(Util.loginUser.getId()));
			fileWriter.append(COMMA_DELIMITER.toString());
			fileWriter.append(String.valueOf(((User)object).getId()));
			fileWriter.append(NEW_LINE_SEPARATOR.toString());

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in friendsFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
				System.out.println("Error while flushing/closing friendsFileWriter !!!");
				e.printStackTrace();
			}
		}



	}

	@Override
	public List<Object> fileReader(String path) {
		return null;
	}
}
