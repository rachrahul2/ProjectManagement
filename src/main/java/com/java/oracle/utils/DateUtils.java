package com.java.oracle.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class DateUtils {

    
    public static Date parseFromString(String date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(date == null || date.isEmpty()) {
            return null;
        } else {
            try {
                return dateFormat.parse(date);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please check date format must like dd/MM/yyyy.");
            }
            return null;
        }
    }
    
    public static String parseFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(date == null) {
            return null;
        } else {
            try {
                return dateFormat.format(date);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please check date format must like dd/MM/yyyy.");
            }
            return null;
        }
    }
}
