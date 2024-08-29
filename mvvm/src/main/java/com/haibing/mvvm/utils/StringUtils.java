package com.haibing.mvvm.utils;

import androidx.annotation.NonNull;

import com.haibing.mvvm.constants.GlobalConstants;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author 王小军
 * @CreateTime 2024年03月21日
 **/

public class StringUtils {
    private static final String TAG = GlobalConstants.TAG_PREFIXES + StringUtils.class.getSimpleName();
    /**
     * @param
     * @return String
     * @desc 拼接字符串
     */
    public static String concat(@NonNull String... param){
        StringBuilder sb = new StringBuilder();
        for(String ss : param) {
            sb.append(ss);
        }
        return sb.toString();
    }

    //通过时间戳获取字符创
    public static String getString(long millis) {
        if(isTimestampFromToday(millis)) {//当天
            //判断是否一个小时以内
            if(isInOneHour(millis)) {
                if(isInOneMinutes(millis)) {
                    return "刚刚";
                } else {
                    return StringUtils.concat(String.valueOf(minutesPassedFromTimestamp(millis)), "min前");
                }
            } else {
                return StringUtils.concat(String.valueOf(getHoursPassedFromTimestamp(millis)), "h前");
            }
        }
        //非当天
        return getYearMonthDay(millis);
    }


    public static int getHoursPassedFromTimestamp(long timestamp) {
        long now = System.currentTimeMillis();
        long temp = now - timestamp;
        // 计算时间过去了多少小时
        int hoursPassed = (int) (temp / (1000 * 60 * 60));

        return hoursPassed;
    }

    public static int minutesPassedFromTimestamp(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis(); // 获取当前时间戳
        long timePassed = currentTime - timestamp; // 计算时间差

        // 将时间差转换为分钟
        return (int) (timePassed / (1000 * 60));
    }

    
    public static boolean isInOneMinutes(long timestamp) {
        long currentTime = System.currentTimeMillis();
        long oneMinuteAgo = currentTime - TimeUnit.MINUTES.toMillis(1);
        return timestamp >= oneMinuteAgo && timestamp <= currentTime;
    }

    //判断是否是一个小时以内
    public static boolean isInOneHour(long timestamp) {
        long now = System.currentTimeMillis();
        long temp = now - timestamp;
        return temp < 60 * 60 * 1000;
    }

    public static boolean isTimestampFromToday(long timestamp) {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);

        Calendar timestampDate = Calendar.getInstance();
        timestampDate.setTimeInMillis(timestamp);
        timestampDate.set(Calendar.HOUR_OF_DAY, 0);
        timestampDate.set(Calendar.MINUTE, 0);
        timestampDate.set(Calendar.SECOND, 0);
        timestampDate.set(Calendar.MILLISECOND, 0);

        return today.getTimeInMillis() == timestampDate.getTimeInMillis();
    }

    public static String getYearMonthDay(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH 从0开始
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);
        
        return StringUtils.concat(String.valueOf(year), "/", String.valueOf(month), "/", String.valueOf(day));
    }
}
