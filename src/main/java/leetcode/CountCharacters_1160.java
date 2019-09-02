package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
注意：每次拼写时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。

示例 1：

输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
解释：
可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
示例 2：

输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
输出：10
解释：
可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 */
public class CountCharacters_1160 {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        int count = countCharacters(words, chars);
        System.out.println("count = " + count);
    }

    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> base = getMap(chars);
        int result = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = getMap(word);
            boolean flag = true;
            for (Character key : wordMap.keySet()) {
                if (base.get(key) == null || wordMap.get(key) > base.get(key)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result += word.length();
            }
        }
        return result;
    }

    public static HashMap getMap(String word) {
        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (wordMap.get(c) == null) {
                wordMap.put(c, 1);
            } else {
                wordMap.put(c, wordMap.get(c) + 1);
            }
        }
        return wordMap;
    }
}
