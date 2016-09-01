package com.phoneNumber;

public enum PhoneType {
	MOBILE(1), 
	Home(2);
	int id;

	PhoneType(int id) {
		this.id = id;
	}

	int getID() {
		return this.id;
	}

}
