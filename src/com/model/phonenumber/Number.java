package com.model.phonenumber;

import com.model.util.Util;

public class Number {
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

    public Number() {
    }

    public Number(int userId, PhoneType type, int number) {
        this.id = ++Util.next_id;
        this.userId = userId;
        this.type = type;
        this.number = number;
    }

}
