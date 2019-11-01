package leetcode;

/**
 * @author: jinyuan
 * @since: 2019/10/30 13:23
 */
/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
*/
public class NumDecodings_91 {
    public static void main(String[] args) {
        String s = "226";
        s = "12";
        int count = numDecodings(s);
        System.out.println("count = " + count);
    }

    /*public static int numDecodings(String s) {
        int len = s.length();
        if (s == null || len == 0) {
            return 0;
        }
        if ((len == 1 && "0".equals(s) || s.indexOf("00") != -1 || s.startsWith("0") || (len > 1 && s.charAt(len - 1) == '0' && Integer.parseInt(s.substring(len - 2)) > 26))) {
            // 字符串0， s包含"00", s以"0"开头，s以0结尾且最后两位大于26
            return 0;
        }

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 1. 如果s[i] != 0： 且s[i-1]不能为0
        //    s[i-1]s[i] <= 26， 则 dp[i] = dp[i-1] + dp[i-2]
        //    s[i-1]s[i] >26, 则 dp[i] = dp[i-1]
        // 2. 如果 s[i] == 0: 且s[i-1]不能为0
        //    s[i-1]s[i] <= 26， 则 dp[i] = dp[i-2]
        // 3. 还有一些情景直接使得整个序列无法被翻译：
        //    相邻的两个 ‘0’
        //    以 ‘0’ 结尾的大于 26 的数字
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) != '0') {
                if (s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                if ((s.charAt(i - 2) - '0') <= 2) {
                    dp[i] = dp[i - 2];
                }
            }
        }

        return dp[len];
    }*/

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

}
