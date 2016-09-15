package com.model.phonenumber;

import com.model.util.Util;

public class PhoneNumber {
    private int id;
    private int userId;
    private PhoneType type;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumber() {
    }

    public PhoneNumber(PhoneType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumber(int userId, PhoneType type, String number) {
        this.userId = userId;
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber {" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", number=" + number +
                '}';
    }


}
