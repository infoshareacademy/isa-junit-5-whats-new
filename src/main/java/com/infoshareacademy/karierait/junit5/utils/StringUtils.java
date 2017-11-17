package com.infoshareacademy.karierait.junit5.utils;

public class StringUtils {
    public static String concat(String arg1, String arg2) {
        if (arg1 == null && arg2 == null) {
            return "";
        }

        if (arg1 == null) {
            return arg2;
        }

        if (arg2 == null) {
            return arg1;
        }

        return arg1.concat(arg2);
    }
}
