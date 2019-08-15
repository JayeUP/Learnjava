package com.yileone.learnjava;

import com.yileone.learnjava.localDateTime.LocalDateTimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.yileone.learnjava.localDateTime.LocalDateTimeUtils.getDayEnd;
import static com.yileone.learnjava.localDateTime.LocalDateTimeUtils.getDayStart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalDateTimeUtilsTest {

    @Test
    public void format_test() {
        System.out.println(LocalDateTimeUtils.formatNow("yyyy年MM月dd日 HH:mm:ss"));
    }

    @Test
    public void betweenTwoTime_test() {
        LocalDateTime start = LocalDateTime.of(1993, 10, 13, 11, 11);
        LocalDateTime end = LocalDateTime.of(1994, 11, 13, 13, 13);
        System.out.println("年:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.YEARS));
        System.out.println("月:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MONTHS));
        System.out.println("日:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.DAYS));
        System.out.println("半日:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.HALF_DAYS));
        System.out.println("小时:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.HOURS));
        System.out.println("分钟:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MINUTES));
        System.out.println("秒:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.SECONDS));
        System.out.println("毫秒:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MILLIS));
        //=============================================================================================
        /*
                                      年:1
                                      月:13
                                      日:396
                                      半日:792
                                      小时:9506
                                      分钟:570362
                                      秒:34221720
                                      毫秒:34221720000
        */
    }

    @Test
    public void plus_test() {
        //增加二十分钟
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.plus(LocalDateTime.now(),
                20,
                ChronoUnit.MINUTES), "yyyy年MM月dd日 HH:mm"));
        //增加两年
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.plus(LocalDateTime.now(),
                2,
                ChronoUnit.YEARS), "yyyy年MM月dd日 HH:mm"));
        //=============================================================================================
        /*
                                        2019年08月15日 15:33
                                        2021年08月15日 15:13
         */
    }

    @Test
    public void dayStart_test() {
        System.out.println(getDayStart(LocalDateTime.now()));
        System.out.println(getDayEnd(LocalDateTime.now()));
        //=============================================================================================
        /*
                                        2017-07-22T00:00
                                2017-07-22T23:59:59.999999999
         */
    }

    @Test
    public void firstDayOfMonth_test() {
        // 打印当月第一天的时间
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.getFirstDayOfMonth(LocalDate.now()),"yyyy年MM月dd日"));
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.getFirstDayDetailOfMonth(LocalDateTime.now()),"yyyy年MM月dd日 HH:mm:ss"));
        // 打印当月最后一天的时间
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.getLastDayOfMonth(LocalDate.now()),"yyyy年MM月dd日"));
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.getLastDayDetailOfMonth(LocalDateTime.now()),"yyyy年MM月dd日 HH:mm:ss"));
    }

}
