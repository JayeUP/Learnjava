package leetcode;

import java.util.*;

/*给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。*/
public class FrequencySort_451 {
    public static void main(String[] args) {
        String s = "Aabb";
        String res = frequencySort(s);
        System.out.println("res = " + res);
    }

    private static class ValueComparator implements Comparator<Map.Entry<Character, Integer>> {
        public int compare(Map.Entry<Character, Integer> m, Map.Entry<Character, Integer> n) {
            return n.getValue() - m.getValue();
        }
    }


    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        // 遍历字符串，记录每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 将list根据map的value值从大到小排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, new ValueComparator());

        // 按序遍历list，然后拼接字符串
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i).getValue();
            char key = list.get(i).getKey();
            while (num > 0) {
                builder.append(key);
                num--;
            }
        }

        return builder.toString();
    }
}
