package leetcode;

import java.util.*;

/**
 * @author: jinyuan
 * @since: 2019/10/30 11:15
 */
/*给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
*/
public class WordBreak_139 {
    public static void main(String[] args) {
        String s = "catsandog";
        s = "applepenapple";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        wordDict = Arrays.asList("apple", "pen");
        boolean b = wordBreak(s, wordDict);
        System.out.println("wordBreak = " + b);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        int length = s.length();
        boolean[] dp = new boolean[length + 1];

        dp[0]=true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    /*public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 状态定义：长度为 i 的子字符串是否符合题意
        boolean[] dp = new boolean[len + 1];

        // 预处理
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }

        // 这个状态的设置非常关键，说明前部分的字符串已经在 wordSet 中
        dp[0] = true;
        for (int r = 1; r < len + 1; r++) {
            for (int l = 0; l < r; l++) {
                // dp[l] 写在前面会更快一点，否则还要去切片，然后再放入 hash 表判重
                if (dp[l] && wordSet.contains(s.substring(l, r))) {
                    dp[r] = true;
                    // 这个 break 很重要，一旦得到 dp[r] = True ，循环不必再继续
                    break;
                }
            }
        }
        return dp[len];
    }*/
}
