package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
有一堆石头，每块石头的重量都是正整数。
每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
*/
public class LastStoneWeight_1046 {
    public static void main(String[] args) {
//        int[] stones = {2,7,4,1,8,1};
        int[] stones = {11,11,12};
        int lastStoneWeight = lastStoneWeight(stones);
        System.out.println("lastStoneWeight = " + lastStoneWeight);
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int length = stones.length;
        if (length == 1) {
            return stones[0];
        }

        // 先得到最重的两块石头
        Arrays.sort(stones);

        while (length > 1){
            int x = stones[length - 2];
            int y = stones[length - 1];
            if (x == y) {
                length -= 2;
            } else {
                // 将剩下的值排序
                int left = y - x;
                length -= 1;
                stones[length - 1] = left;
                BubbleSort(stones, length);
            }
        }
        if (length == 0) {
            return 0;
        } else {
            return stones[0];
        }
    }

    // 直接插入排序
    public static int[] BubbleSort(int[] base, int length) {
        if (length <= 1) {
            return base;
        }
        int x = base[length-1]; // 要移动的值
        int i = length - 2;
        if (base[i] <= x) {
            return base;
        }
        for (i = length-2; i >= 0; i--) {
            if (base[i] > x) {
                base[i+1] = base[i];
            } else {
                break;
            }
        }
//        i = i < 0 ? 0 : i ;
        base[i+1] = x;
        return base;
    }
}
