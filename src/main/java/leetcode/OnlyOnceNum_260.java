package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 */
public class OnlyOnceNum_260 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] ints = singleNumber(nums);
        System.out.println("collect = " + Arrays.toString(ints));
    }

    public static int[] singleNumber(int[] nums) {
        /*Arrays.sort(nums);
        int[] res = new int[2];
        int resNum = 0;
        for (int i = 0; i < nums.length-1; i+=2) {
            int minus =  nums[i] ^ nums[i+1];
            if (minus != 0) {
                res[resNum] = nums[i];
                resNum ++;
                i--;
            }
        }
        if (resNum < 2) {
            res[resNum] = nums[nums.length-1];
        }
        return res;*/

        int xor = 0;
        // 异或整个数组，得到只出现一次的两个数的异或值
        for (int num : nums) {
            xor ^= num;
        }

        int mark = xor & (-xor);    // 将异或值与其相反值 相与，得到 不同值得补码不相同的最低位 为1的值
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mark) == mark) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }


}
