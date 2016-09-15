package com.controller;


public enum AppCommands {

    SIGN_UP("Sign Up"),
    SIGN_IN("Sign In"),
    EDIT_PROFILE("Edit profile"),
    DELETE_PROFILE("Delete profile");


    String comand;

    AppCommands(String comand) {
        this.comand = comand;
    }

    public String getComand() {
        return comand;
    }

    public void setComand(String comand) {
        this.comand = comand;
    }
}
