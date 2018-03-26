package com.dfire.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 17:49 2018/3/22
 * @desc Zeus日期工具类, 用于界面配置项的动态替换
 */
public class ZeusDateTool {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private Calendar calendar = Calendar.getInstance();

    public ZeusDateTool(Date date) {
        this.calendar.setTime(date);
    }

    public ZeusDateTool addDay(int amount) {
        calendar.add(Calendar.DAY_OF_YEAR, amount);
        return this;
    }

    public ZeusDateTool add(int field, int amount) {
        calendar.add(field, amount);
        return this;
    }

    public String format(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(calendar.getTime());
    }

    /**
     * @param dateStr   需要转换的字符串
     * @param formatStr 需要格式的目标字符串  举例 yyyy-MM-dd
     * @return outFormatStr 需要格式的输出字符串  举例 yyyy-MM-dd
     * @throws ParseException 转换异常
     * @desc 日期格式字符串互相转换
     */
    public static String StringToDateStr(String dateStr, String formatStr, String outFormatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        SimpleDateFormat outDateFormat = new SimpleDateFormat(outFormatStr);
        Date date = null;
        String outDateStr = "";
        try {
            date = sdf.parse(dateStr);
            outDateStr = outDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outDateStr;
    }

    /**
     * @param dateStr   需要转换的字符串
     * @param formatStr 需要格式的目标字符串  举例 yyyy-MM-dd
     * @return Date 返回转换后的时间
     * @throws ParseException 转换异常
     * @desc 字符串转换到时间格式
     */
    public static Date StringToDate(String dateStr, String formatStr) {
        DateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getToday() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}