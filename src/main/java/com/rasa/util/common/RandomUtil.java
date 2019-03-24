package com.rasa.util.common;


import java.text.SimpleDateFormat;
import java.util.Date;


public class RandomUtil {

    // 返回2007-01-01到2007-03-01的一个随机日期
    public static void main(String[] args) {
        Date randomDate = randomDate("2007-01-01", "2007-03-01");
        System.out.println(randomDate.toString());
    }

    /**
     * 获取随机日期
     *
     * @param beginDate 起始日期，格式为：yyyy-MM-dd
     * @param endDate   结束日期，格式为：yyyy-MM-dd
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期

            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = randomNumber(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get random number between begin and end
     * @param begin
     * @param end
     * @return
     */
    public static long randomNumber(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return randomNumber(begin, end);
        }
        return rtn;
    }

}