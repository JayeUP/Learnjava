package leetcode;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jinyuan
 * @since: 2019/10/25 16:41
 */

/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。

示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]

示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/
public class CombinationSum_39 {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println("lists = " + JSONUtil.toJsonStr(lists));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || (candidates.length == 1 && candidates[0] != target)) {
            return null;
        }

        ArrayList<List<Integer>> result = new ArrayList<>();

        // 从后往前遍历candidates找到<=target的最大值
        int index = -1;
        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] <= target) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        for (int i = index; i >= 0; i--) {
            for (int j = candidates[i]; j <= target; j+=candidates[i]) {

            }
        }

        return result;
    }
}
