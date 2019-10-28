package leetcode;

/**
 * @author: jinyuan
 * @since: 2019/10/28 17:00
 */

/*
峰值元素是指其值大于左右相邻值的元素。
给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
你可以假设 nums[-1] = nums[n] = -∞。

示例 1:
输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。

示例 2:
输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。


说明:
你的解法应该是 O(logN) 时间复杂度的。
 */
public class FindPeakElement_162 {
    public static void main(String[] args) {
//        int[] nums = {1,2,1,3,5,6,4};
//        int[] nums = {1,2,3,1};
        int[] nums = {1,2};
        int peakIndex = findPeakElement(nums);
        System.out.println("peakIndex = " + peakIndex);
    }

    public static int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        // 二分法
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = low + (high- low) /2;
            if ((mid == 0 || (mid > 0 && nums[mid] > nums[mid - 1])) && (mid == length - 1 || (mid < length - 1 && nums[mid] > nums[mid + 1]))) {
                // 找到峰值
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                // 当前值小于其左边的值
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }
}
