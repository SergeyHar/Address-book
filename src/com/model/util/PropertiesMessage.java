package com.model.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sergo on 14-Sep-16.
 */
public class PropertiesMessage extends Properties {

    static Properties prop = new Properties();

    public static String getDbMessage(String key) {
        String result = null;

        try {
            prop.load(new FileInputStream("src\\properties\\db.properties"));
            result = prop.getProperty(key);
        } catch (IOException io) {
            io.printStackTrace();
        }

        return result;
    }

    public String getMessage(String key) {
        String result = null;

        try {
            prop.load(new FileInputStream("src\\properties\\data.properties"));
            result = prop.getProperty(key);
        } catch (IOException io) {
            io.printStackTrace();
        }

        return result;
    }


}
