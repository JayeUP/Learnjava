package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/*
将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。

示例 1:

输入: 123
输出: "One Hundred Twenty Three"
示例 2:

输入: 12345
输出: "Twelve Thousand Three Hundred Forty Five"
示例 3:

输入: 1234567
输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
示例 4:

输入: 1234567891
输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class NumberToWords_273 {
    public static void main(String[] args) {
        int num = 12345;
        num = 1000000;
        String words = numberToWords(num);
        System.out.println( num + " = " + words);
    }

    public static String numberToWords(int num) {
        // 个位保存1~9的数组
        String[] units = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        // 10~19的数组
        String[] tens1 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        // 十位20~90的数组
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        // 每三位的进制
        String[] carries = {"", "Thousand", "Million", "Billion", "Trillion"};
        String hundred = "Hundred ";

        // num为0时，做特殊处理
        if (num == 0) {
            return units[num];
        }

        // 1.现将num从低位 每3位 进行分段
        ArrayList<Integer> nums = new ArrayList<>();
        while (num != 0) {
            nums.add(num % 1000);
            num /= 1000;
        }

        // 2.遍历list，并拼接最后结果
        StringBuilder builder = new StringBuilder();
        int carry = nums.size() - 1;
        for (int i = carry; i >= 0; i--) {
            Integer number = nums.get(i);
            if (number == 0) {
                continue;   //如果当前的三个数都是0，直接返回
            }

            // 当前数字是三位，即最高位不为0
            if (number >= 100) {
                builder.append(units[number / 100] + " ");
                builder.append(hundred);
                number %= 100;
            }

            // 当前数字是两位
            if (number >= 10) {
                if (number < 20) {
                    // 10~19中的数字
                    builder.append(tens1[number % 10] + " ");
                    builder.append(carries[i] + " ");
                    continue;   // 直接返回
                } else {
                    // 20~99中的数字
                    builder.append(tens[number / 10] + " ");
                    number %= 10;
                }
            }

            // 当前数字是一位
            if (number > 0) {
                builder.append(units[number] + " ");
            }

            builder.append(carries[i] + " ");
        }

        return builder.toString().trim();
    }
}
