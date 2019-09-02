package leetcode;

import java.util.Arrays;

public class ProductExceptSelf_238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = productExceptSelf(nums);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = 1;
        int[] res = new int[length];
        // res数组值初始化为1
        for (int i = 0; i < length; i++) {
            res[i] = 1;
        }
        // 遍历nums，左积*右积
        for (int i = 0; i < length; i++) {
            res[i] *= left;
            left *= nums[i];

            res[length-1-i] *= right;
            right *= nums[length-1-i];
        }

        return res;
    }
}
