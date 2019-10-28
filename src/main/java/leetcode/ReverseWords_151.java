package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: jinyuan
 * @since: 2019/10/28 19:05
 */
/*
给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

说明：
无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
*/
public class ReverseWords_151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        s = "  hello world!  ";
        s = "a good   example";
        String result = reverseWords(s);
        System.out.println("reverseWords = " + result);

    }

    public static String reverseWords(String s) {
        s = s.trim();
        String[] splits = s.split(" ");
        System.out.println("splits = " + Arrays.toString(splits));

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < splits.length; i++) {
            String temp = splits[i];
            if ("".equals(temp) || " ".equals(temp)) {
                continue;
            } else {
                stack.push(temp);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop() + " ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        return stringBuilder.toString().trim();
    }
}
