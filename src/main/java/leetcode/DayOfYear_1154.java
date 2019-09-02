package leetcode;

import org.apache.commons.lang3.StringUtils;

/*
给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

示例 1：

输入：date = "2019-01-09"
输出：9
示例 2：

输入：date = "2019-02-10"
输出：41
示例 3：

输入：date = "2003-03-01"
输出：60
示例 4：

输入：date = "2004-03-01"
输出：61
 */
public class DayOfYear_1154 {
    public static void main(String[] args) {
        String date = "2004-03-01";
        int dayOfYear = dayOfYear(date);
        System.out.println("dayOfYear = " + dayOfYear);
    }

    public static int dayOfYear(String date) {
        int[] daysOfMouth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int dayOfYear = 0;
        // 先从date中得到月和日
        Integer year = Integer.valueOf(date.substring(0, 4));
        Integer mouth = Integer.valueOf(date.substring(5, 7));
        Integer day = Integer.valueOf(date.substring(8));
        for (int i = 1; i < mouth; i++) {
            dayOfYear += daysOfMouth[i];
        }
        dayOfYear += day;
        // 如果月份大于3，再判断是否是闰年
        if (mouth > 2 && ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))) {
            dayOfYear += 1;
        }
        return dayOfYear;
    }
}
