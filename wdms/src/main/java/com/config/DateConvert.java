/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;
import com.config.ad.AdToBs;
import com.config.bs.BsToAd;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConvert {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
     private static SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static String today() {
        return df.format(new Date());
    }

    public static String now() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return df.format(new Date());
    }

    public static Date addDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    public static Date addDate(String date, int day) {
        Date d = toDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }

    public static String toString(Date date) {
        return df.format(date);
    }

    public static Date toDate(String date) {
        try {
            return df.parse(date);
        } catch (Exception e) {
        }
        return null;
    }
public static Date toDateTime(String date) {
        try {
            return dateTime.parse(date);
        } catch (Exception e) {
        }
        return null;
    }
    public static String adToBs(Date date) {
        try {
            if (date != null) {
                return new AdToBs().convet(df.format(date));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Enter Date Error");
        }
        return null;
    }

    public static String adToBs(String date) {
        try {
            return new AdToBs().convet(date);
        } catch (Exception e) {
        }
        return null;
    }

    public static String bsToAd(String date) {
        try {
            return new BsToAd().convet(date);
        } catch (Exception e) {
        }
        return null;
    }

    public static Date bsToAdDate(String date) {
        try {
            return df.parse(new BsToAd().convet(date));
        } catch (Exception e) {
        }
        return null;
    }

}
