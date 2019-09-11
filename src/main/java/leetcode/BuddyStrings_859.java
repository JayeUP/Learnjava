package leetcode;
/*给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。

示例 1：

输入： A = "ab", B = "ba"
输出： true
示例 2：

输入： A = "ab", B = "ab"
输出： false
示例 3:

输入： A = "aa", B = "aa"
输出： true
示例 4：

输入： A = "aaaaaaabc", B = "aaaaaaacb"
输出： true
示例 5：

输入： A = "", B = "aa"
输出： false
*/
public class BuddyStrings_859 {
    public static void main(String[] args) {
        String A = "abcaa";
        String B = "abcbb";
        boolean flag = buddyStrings(A, B);
        System.out.println("flag = " + flag);
    }

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int differentNum = 0;   // 记录两个字符串不同的字符的数量
        boolean flag = false;   // A是否含有重复字符的标志
        char firstA = ' ';
        char firstB = ' ';
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                differentNum ++;
                if (differentNum == 1) {
                    // 记录下第一次 两者不同的字符值
                    firstA = A.charAt(i);
                    firstB = B.charAt(i);
                } else if (differentNum == 2) {
                    // 拿第二次不同的值 与第一次的值比较 是否相对应
                    if (firstA != B.charAt(i) || firstB != A.charAt(i)) {
                        return false;
                    }
                } else {
                    // 有两处以上不同 则为false
                    return false;
                }
            }
            if (i != A.lastIndexOf(A.charAt(i))) {
                // 判断A字符串是否有重复字符
                flag = true;
            }
        }
        if (differentNum == 2) {
            // 两个String有两处不同
            return true;
        }
        if (differentNum == 0 && flag == true) {
            // 两个String相同的情况，再判断A字符串中是否有相同的字符
            return true;
        }
        return false;
    }
}
