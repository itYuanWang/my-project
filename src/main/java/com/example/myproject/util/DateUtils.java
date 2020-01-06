package com.example.myproject.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-12-09 16:47
 **/
@Slf4j
public class DateUtils {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_FORMAT = "yyyyMMddHHmmss";

    public static final String FULL_TIME = "yyyyMMddHHmmssSSS";

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 获取输入日期当天23:59:59的date
     *
     * @param date
     * @return
     */
    public static Date getDayEndDate(String date){
        Calendar c = Calendar.getInstance();
        c.setTime(stringToDate(date,DATE_FORMAT));
        c.set(Calendar.HOUR_OF_DAY,23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        c.set(Calendar.MILLISECOND,999);
        return c.getTime();
    }

    private static Date stringToDate(String date, String dateFormat) {
        return null;
    }


    /**
     * 将字符串形式的时间转换成long
     *
     * @param time   time
     * @param format format
     * @return return
     */
    public static Long StringToTime(String time, String format) {
        if (StringUtils.isEmpty(time)) {
            return 0l;
        }
        Long result = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            result = simpleDateFormat.parse(time).getTime() / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 将 时间戳 转换成 字符串
     *
     * @param time   time
     * @param format format
     * @return return
     */
    public static String longToString(Integer time, String format) {
        String result = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            result = simpleDateFormat.format(time * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
