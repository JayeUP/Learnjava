package com.yileone.learnjava.localDateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo {
    public static void main(String[] args) {
        // 取当前日期
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today); //today = 2019-08-15
        // 根据年月日取日期，12月就是12；
        LocalDate crischristmas = LocalDate.of(2014, 12, 25);;
        System.out.println("crischristmas = " + crischristmas); //crischristmas = 2014-12-25
        // 根据字符串取
        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
        System.out.println("endOfFeb = " + endOfFeb);   //endOfFeb = 2014-02-28
//        LocalDate.parse("2014-02-29");  // 无效日期无法通过：DateTimeParseException: Invalid date

        // 取本月第1天
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfThisMonth = " + firstDayOfThisMonth); //firstDayOfThisMonth = 2019-08-01
        // 取本月第2天
        LocalDate secondDayOfThisMont = today.withDayOfMonth(2);
        System.out.println("secondDayOfThisMont = " + secondDayOfThisMont); //secondDayOfThisMont = 2019-08-02
        // 取本月最后一天，再也不用计算是28,29,30还是31
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfThisMonth = " + lastDayOfThisMonth);   //lastDayOfThisMonth = 2019-08-31
        // 取下一天
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1);
        System.out.println("firstDayOf2015 = " + firstDayOf2015);    //firstDayOf2015 = 2019-09-01
        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println("firstMondayOf2015 = " + firstMondayOf2015); //firstMondayOf2015 = 2015-01-05
    }
}
