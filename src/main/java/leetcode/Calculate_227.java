package leetcode;

/**
 * @author: jinyuan
 * @since: 2019/10/28 19:32
 */
/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:
输入: "3+2*2"
输出: 7

示例 2:
输入: " 3/2 "
输出: 1

示例 3:
输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。
*/
public class Calculate_227 {
    public static void main(String[] args) {
        String s = "4-3+2*2";
        int result = calculate(s);
        System.out.println("result = " + result);
    }

    public static int calculate(String s) {
        int result = 0;
        s =s.trim();
        int i = 0;

        String first = findNextNum(s, i);
        String second = findNextNum(s, i);

        while (i<s.length()){
            String nextNum = findNextNum(s, i);
            String nextSign = findNextSign(s, i);

        }

        return result;
    }

    public static String findNextSign(String s, int i) {
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(i);
            if ('+' == c || '-' == c || '*' == c || '/' == c) {
                return c + "";
            }
        }
        return "";
    }

    public static String findNextNum(String s, int i) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static int calculate(String sign, String first, String second) {
        int firstNum = Integer.parseInt(first);
        int secondNum = Integer.parseInt(second);
        int result = 0;
        if ("+".equals(sign)) {
            result = firstNum + secondNum;
        } else if ("-".equals(sign)) {
            result = firstNum - secondNum;
        } else if ("*".equals(sign)) {
            result = firstNum * secondNum;
        } else if ("/".equals(sign)) {
            result = firstNum / secondNum;
        }
        return result;
    }
}
