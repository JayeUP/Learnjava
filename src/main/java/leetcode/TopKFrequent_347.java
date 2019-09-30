package leetcode;

import java.util.*;

/*给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
*/
public class TopKFrequent_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> list = topKFrequent(nums, k);
        System.out.println("list = " + list.toString());
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 遍历nums数组，记录每个值出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 将list根据map的value值从大到小排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, new ValueComparator());

        // 获取出现频率前 k 高的元素
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resList.add(list.get(i).getKey());
        }
        return resList;
    }

    private static class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return o2.getValue() - o1.getValue();
        }
    }
}
