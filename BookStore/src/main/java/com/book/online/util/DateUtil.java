package com.book.online.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 根据年、月、日创建日 期对象
     */
    public static Date createDate(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date);
        return cal.getTime();
    }

    /**
     * 格式化日 期 
     */
    public static String format(Date d, String pattern) {
        String sdate = null;
        if (null != d && null != pattern) {
            sdate = new SimpleDateFormat(pattern).format(d);
        }
        return sdate;
    }

    /**
     * 解析日 期
     */
    public static Date parse(String dateStr, String pattern) {
        Date d = null;
        if (null != dateStr && null != pattern) {
            try {
                d = new SimpleDateFormat(pattern).parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return d;
    }

}
