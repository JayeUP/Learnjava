package leetcode;

/**
 * @author: jinyuan
 * @since: 2019/10/25 15:20
 */

/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
*/
public class CanJump_55 {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3,2,1,0,4};
        boolean canJump = canJump(nums);
        System.out.println("canJump = " + canJump);
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        // 先检查一遍 是否有存在每个位置都无法到达最后一个位置的情况的情况
        int length = nums.length;
        boolean cantFlag = true;
        for (int i = length-2; i >= 0; i--) {
            if (i + nums[i] >=length -1) {
                cantFlag = false;
                break;
            }
        }
        if (cantFlag) {
            return false;
        }

        return jump(nums, 0);
    }

    public static boolean jump(int[] nums, int i) {
        if (i == nums.length-1) {
            // 到了最后一格
            return true;
        }

        boolean result = false;
        for (int j = nums[i]; j > 0; j--) {
            if (i + j >= nums.length) {
                continue;
            }
            boolean temp = jump(nums, i + j);
            if (temp) {
                result = temp;
                break;
            }
        }
        return result;
    }
}
