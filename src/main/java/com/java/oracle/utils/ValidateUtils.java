package com.java.oracle.utils;

public class ValidateUtils {
    public static boolean isNumber(String input) {
        try {
            Double num = Double.valueOf(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
