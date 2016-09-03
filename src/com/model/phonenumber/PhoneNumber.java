package com.model.phonenumber;

import com.model.util.Util;

public class PhoneNumber {
    private int id;
    private int userId;
    private PhoneType type;
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PhoneNumber() {
    }

    public PhoneNumber(int userId, PhoneType type, int number) {
        this.id = ++Util.next_id;
        this.userId = userId;
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", number=" + number +
                '}';
    }
}
