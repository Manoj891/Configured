package com.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {

    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public static String today() {
        return df.format(new Date());
    }

    public static String now() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return df.format(new Date());
    }

    public static Date date(String sDate) {       
        try {
            return df.parse(sDate);
        } catch (Exception e) {
        }
        return null;
    }

    public static Date toDate(String sDate) {
          try {
            return df.parse(sDate);
        } catch (Exception e) {
        }
        return null;
    }
}
