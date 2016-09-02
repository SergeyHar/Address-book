package com.model.util;

import com.model.User;

public class Util {
//    private static int next_id = 0;
    public static int next_id =0;

    public static void reset_counter(int n) // use with care!
    {
        Util.next_id = n;
    }

}
