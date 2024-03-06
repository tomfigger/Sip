package com.feige.init.utils;

import com.blankj.utilcode.util.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * MrLiu253@163.com
 *
 * @time 2/18/22
 * 描述:
 */
public class BaseTime {
    // ====================================================================================
    // 获取显示时间
    // ====================================================================================

    public static String getShowTime(long milliseconds, boolean abbreviate) {
        // 输入时间（日期）
        Date inputData = new Date(milliseconds);
        // 输入时间（时分）
        String inputTime24 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(inputData);

        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);

        // 今天的开始
        Date todayBegin = todayStart.getTime();
        // 昨天的开始
        Date yesterdayBegin = new Date(todayBegin.getTime() - 3600 * 24 * 1000);
        // 前天的开始
        Date preYesterdayBegin = new Date(yesterdayBegin.getTime() - 3600 * 24 * 1000);

        String dataString;

        if (!inputData.before(todayBegin)) {// 今天
            dataString = inputTime24;
        } else if (!inputData.before(yesterdayBegin)) {// 昨天
            if (abbreviate) {
                dataString = "昨天";
            } else {
                dataString = "昨天 " + inputTime24;
            }
        } else if (!inputData.before(preYesterdayBegin)) {// 前天
            if (abbreviate) {
                dataString = "前天";
            } else {
                dataString = "前天 " + inputTime24;
            }
        } else if (isSameWeekDates(inputData, new Date())) {// 本周
            if (abbreviate) {
                dataString = getWeekOfDate(inputData);
            } else {
                dataString = getWeekOfDate(inputData) + " " + inputTime24;
            }
        } else if (isSameYearDates(inputData, new Date())) {// 本年
            if (abbreviate) {
                dataString = new SimpleDateFormat("MM-dd", Locale.getDefault()).format(inputData);
            } else {
                dataString = new SimpleDateFormat("MM-dd", Locale.getDefault()).format(inputData) + " " + inputTime24;
            }
        } else {// 其他
            if (abbreviate) {
                dataString = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(inputData);
            } else {
                dataString = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(inputData) + " " + inputTime24;
            }
        }

        return dataString;
    }

    /**
     * 是否在同一周
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameWeekDates(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
        if (0 == subYear) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
            // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
            if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
                return true;
        }
        return false;
    }

    /**
     * 根据日期获得星期
     *
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDaysName = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        // String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDaysName[intWeek];
    }

    /**
     * 是否同一年
     *
     * @param current
     * @param today
     * @return
     */
    private static boolean isSameYearDates(Date current, Date today) {
        Calendar currentCal = Calendar.getInstance();
        Calendar todayCal = Calendar.getInstance();
        currentCal.setTime(current);
        todayCal.setTime(today);
        return currentCal.get(Calendar.YEAR) == todayCal.get(Calendar.YEAR);
    }

    //获取昨天时间
    public static String getYesterDay() {
        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(cal.getTime());
        return yesterday;
    }

    //获取今天时间
    public static String getToDay() {
        Calendar cal = Calendar.getInstance();
        String yesterday = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(cal.getTime());
        return yesterday;
    }
    //获取今天时间
//    public static String getToDay() {
//        TimeUtils.getNowString("yyyy-MM-dd")
//        return yesterday;
//    }
}
