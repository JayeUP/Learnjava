package leetcode;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations_46 {

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        Permutations_46 solution = new Permutations_46();
        List<List<Integer>> lists = solution.permute(arr);
        System.out.println("lists = " + lists.toString());
    }

    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        perm(nums, 0, nums.length-1);
        return result;
    }

    public void perm(int[] nums, int start, int end) {
        if (start == end) {
//            Integer[] integers = ArrayUtils.toObject(nums);
//            List<Integer> num = Arrays.asList(integers);
            List<Integer> num = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(num);
            return;
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                perm(nums, start+1, end);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
