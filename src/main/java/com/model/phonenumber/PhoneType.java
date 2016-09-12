package com.model.phonenumber;

public enum PhoneType {
	MOBILE(1), 
	HOME(2),
	WORK(3)	;
	int id;

	PhoneType(int id) {
		this.id = id;
	}

	int getID() {
		return this.id;
	}

}
