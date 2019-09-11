package leetcode;
/*给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。题目保证至少有一个词不在禁用列表中，而且答案唯一。
禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。

示例：

输入:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
输出: "ball"
解释:
"hit" 出现了3次，但它是一个禁用的单词。
"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
*/

import java.util.*;

public class MostCommonWord_819 {
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
//        paragraph = "Bob!";
        String[] banned = {"a"};
        String commonWord = mostCommonWord1(paragraph, banned);
        System.out.println("commonWord = " + commonWord);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        for (int i = 0; i < banned.length; i++) {
            paragraph = paragraph.replaceAll(banned[i],"");
        }

        StringBuilder builder = new StringBuilder(paragraph);
        for (int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i);
            if (c != ' ' && (c < 'a' || c > 'z')) {
                builder.replace(i, i+1, " ");
            }
        }

        paragraph = builder.toString().trim();
        String[] strings = paragraph.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (s.length() == 0) {
                continue;
            }
            if (map.get(s) == null) {
                map.put(s,1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                res = entry.getKey();
                max = entry.getValue();
            }
        }
        return res;
    }

    public static String mostCommonWord1(String paragraph, String[] banned) {
        // 数组转Set，并将空字符串加入其中
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        set.add("");

        // paragraph最后添加一个非字母符号，防止最后一个是字母的情况不会记录下该字母
        paragraph += ",";

        // 记录单词出现次数的map
        HashMap<String, Integer> map = new HashMap<>();
        // 最大单词出现次数
        int maxTime = 0;
        // 返回结果
        String res = "";

        int i = 0;
        for (int j = 0; j < paragraph.length(); j++) {
            char c = paragraph.charAt(j);
            if ((c>='a' && c<='z') || (c>='A'&&c<='Z')) {
                continue;
            }
            // 取出每一个字母
            String word = paragraph.substring(i, j).toLowerCase();
            if (!set.contains(word)) {
                // 当前字母不在banned中
                map.put(word, map.getOrDefault(word,0) + 1);
                if (map.get(word) > maxTime) {
                    maxTime = map.get(word);
                    res = word;
                }
            }
            i = j +1;
        }
        return res;
    }

}
