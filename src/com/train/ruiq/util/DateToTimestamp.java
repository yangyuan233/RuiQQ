package com.train.ruiq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToTimestamp {

    /**
     * 将java.util.Date对象转化为java.sql.Timestamp对象
     *
     * @param date
     *            要转化的java.util.Date对象
     * @return 转化后的java.sql.Timestamp对象
     */
    public static java.sql.Timestamp dateToTime(java.util.Date date) {
        String strDate = dateToStr(date, "yyyy-MM-dd HH:mm:ss SSS");
        return strToSqlDate(strDate, "yyyy-MM-dd HH:mm:ss SSS");
    }
    /**
     * 将String字符串转换为java.sql.Timestamp格式日期,用于数据库保存
     * @param strDate
     *            表示日期的字符串
     * @param dateFormat
     *            传入字符串的日期表示格式（如："yyyy-MM-dd HH:mm:ss"）
     * @return java.sql.Timestamp类型日期对象（如果转换失败则返回null）
     */
    public static java.sql.Timestamp strToSqlDate(String strDate, String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);//构造一个 SimpleDateFormat使用给定的模式设置的默认日期格式符号。
        java.util.Date date = null;
        try {
            date = sf.parse(strDate);//从字符串中解析文本以产生一个 Date 。
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
        //getTime()返回自1970年1月1日以来，由此 Date对象表示的00:00:00 GMT的毫秒数 。
        //Timestamp(long time)   使用毫秒时间值构造一个 Timestamp对象
        return dateSQL;
    }
    public static String dateToStr(Date date, String strFormat) {
        DateFormat df = new SimpleDateFormat(strFormat);//构造一个 SimpleDateFormat使用给定的模式设置的默认日期格式符号。
        String str = df.format(date);//format()将日期格式化成日期/时间字符串
        return str;
    }

}