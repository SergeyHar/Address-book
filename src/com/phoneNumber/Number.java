package com.phoneNumber;

public class Number {
	private PhoneType type;
	private int number;

	
	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Number(PhoneType type, int number) {
		this.type = type;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Number type=" + type + ", number=" + number ;
	}

 

}
