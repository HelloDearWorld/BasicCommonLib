/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * DataUtils.java
 */
package com.basiccommonlib.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author
 * @since 16/7/11 下午2:58
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class DataUtils {


    private static final String formatType        = "yyyy-MM-dd HH:mm:ss";
    private static final String custom_formatType = "HH时:mm分:ss秒";
    private static final String shortFormatType   = "yyyy-MM-dd";

    /// date类型转换为String类型
    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data) {
        return new SimpleDateFormat(formatType).format(data);
    }

    public static String dateToString(Date data, String fromatType) {
        return new SimpleDateFormat(fromatType).format(data);
    }

    // long类型转换为String类型
    // currentTime要转换的long类型的时间
    // formatType要转换的string类型的时间格式
    public static String longToString(long currentTime) throws ParseException {
        Date date = longToDate(currentTime); // long类型转成Date类型
        String strTime = dateToString(date, shortFormatType); // date类型转成String
        return strTime;
    }

    public static String longToStringWithShort(long currentTime) throws ParseException {
        Date date = longToDate(currentTime); // long类型转成Date类型
        String strTime = dateToString(date); // date类型转成String
        return strTime;
    }

    public static String longToStringWithCustom(long currentTime) throws ParseException {
        Date date = longToDate(currentTime); // long类型转成Date类型
        String strTime = dateToString(date, custom_formatType); // date类型转成String
        return strTime;
    }

    // string类型转换为date类型
    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // long转换为Date类型
    // currentTime要转换的long类型的时间
    // formatType要转换的时间格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    public static Date longToDate(long currentTime) throws ParseException {
        currentTime = currentTime * 1000;
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime); // 把String类型转换为Date类型
        return date;
    }

    // string类型转换为long类型
    // strTime要转换的String类型的时间
    // formatType时间格式
    // strTime的时间格式和formatType的时间格式必须相同
    public static long stringToLong(String strTime) throws ParseException {
        Date date = stringToDate(strTime); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    // date类型转换为long类型
    // date要转换的date类型的时间
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    public static Date getCurrentData() {
        Date nowDate = Calendar.getInstance().getTime();
        return nowDate;
    }

    /**
     * 计算当前时间和传入时间间隔的秒数
     *
     * @param startDate
     * @return
     */
    public static int getDateDistance(Date startDate) {

        Date endDate = Calendar.getInstance().getTime();

        if (startDate == null || endDate == null) {
            return 0;
        }

        long timeLong = endDate.getTime() - startDate.getTime();
        return (int) (timeLong / 1000);
    }
}