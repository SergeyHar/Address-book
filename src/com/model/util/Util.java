package com.model.util;

import com.model.User;
import com.model.phonenumber.PhoneType;

import java.io.File;

public class Util {
    public static User loginUser = null;
    public static final String PATH = "";
    public static int next_id = 0;


    public static String projectDirectory() {
        File file = new File(PATH);
        if (!file.mkdir()) {
            file.mkdirs();
        }
        return PATH;
    }

    public static void reset_counter(int n) // use with care!
    {
        Util.next_id = n;
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
