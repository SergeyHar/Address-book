package com.model.util;

import com.model.User;
import com.model.phonenumber.PhoneType;

import java.io.File;

public class Util {
    public static User loginUser = null;
    public static String path = "";
    public static int userNextId = 0;
    public static int phoneNumberNextId = 0;

    public static String projectDirectory() {
        File file = new File(path);
        file.mkdirs();
        return path;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(InvalidArgumentException invArgExcepMessage) {
        System.out.println(invArgExcepMessage);
    }

    public static PhoneType checkType(int type) {
        PhoneType result;
        switch (type) {
            case 2:
                result = PhoneType.HOME;
                break;
            case 3:
                result = PhoneType.WORK;
                break;
            default:
                result = PhoneType.MOBILE;
                break;
        }

        return result;
    }
}
