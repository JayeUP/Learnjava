package leetcode;

import java.util.HashMap;

/*在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
返回重复了 N 次的那个元素。

示例 1：

输入：[1,2,3,3]
输出：3
示例 2：

输入：[2,1,2,5,3,2]
输出：2
示例 3：

输入：[5,1,5,2,5,3,5,4]
输出：5
*/
public class RepeatedNTimes_961 {
    public static void main(String[] args) {
        int[] A = {5,1,5,2,5,3,5,4};
        int num = repeatedNTimes(A);
        System.out.println("num = " + num);
    }

    public static int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) > 1) {
                return A[i];
            }
        }
        return 0;
    }
}
