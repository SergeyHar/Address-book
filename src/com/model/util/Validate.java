package com.model.util;

public class Validate {
    public static String notNull(String value) {
        if (value == null || value.equals("")) {
            try {
                throw new MyExceptions("Input value can't be empty");
            } catch (MyExceptions e) {
                System.out.println(e);
//                e.printStackTrace();
            }
        }

        return value;

    }


    public static String md5(String value) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(value.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
