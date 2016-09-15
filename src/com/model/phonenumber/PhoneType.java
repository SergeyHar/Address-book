package com.model.phonenumber;

public enum PhoneType {
    MOBILE("mobile"),
    HOME("home"),
    WORK("work");
    String type;

    PhoneType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
