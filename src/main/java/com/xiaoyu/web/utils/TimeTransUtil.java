package com.xiaoyu.web.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @program: rry
 * @description: 时间转换工具
 * @author: XiaoYu
 * @create: 2018-03-20 14:10
 **/
public class TimeTransUtil {
    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     *
     * @param timestampString 时间戳 如："1473048265";
     * @param formats         要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        return new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
    }

    public static String DateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
        return formatter.format(date);
    }

    public static Date getSixBeforeTime(){
        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.add(Calendar.HOUR, -6);
        return calendar.getTime();
    }

}
