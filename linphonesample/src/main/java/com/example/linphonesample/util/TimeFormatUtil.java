package com.example.linphonesample.util;

public class TimeFormatUtil {
    public static String getVideoFormat(long time) {
        int temp = (int) time;
        int hh = temp / 3600;
        int mm = (temp % 3600) / 60;
        int ss = (temp % 3600) % 60;
        String hhStr = hh <= 0 ? "" : (hh < 10 ? ("0" + hh) : hh) + ":";
        return hhStr +
                (mm < 10 ? ("0" + mm) : mm) + ":" +
                (ss < 10 ? ("0" + ss) : ss);
    }
}
