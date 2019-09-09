package leetcode;
/*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1:
s = "abc", t = "ahbgdc"

返回 true.

示例 2:
s = "axc", t = "ahbgdc"

返回 false.
*/

public class IsSubsequence_392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println("isSubsequence = " + subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int ti = -1;
        int tLength = t.length();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            ti++;
            while (ti < tLength && t.charAt(ti) != sc) {
                ti++;
            }
            if (ti >= tLength) {
                return false;
            }
        }
        return true;
    }

}
