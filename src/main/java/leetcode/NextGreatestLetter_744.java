package leetcode;
/*
给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
示例:

输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "c"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "d"
输出: "f"

输入:
letters = ["c", "f", "j"]
target = "g"
输出: "j"

输入:
letters = ["c", "f", "j"]
target = "j"
输出: "c"

输入:
letters = ["c", "f", "j"]
target = "k"
输出: "c"
*/
public class NextGreatestLetter_744 {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'c';
        char c = nextGreatestLetter(letters, target);
        System.out.println("c = " + c);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int low = 0;
        int high = length -1;
        int mid = low + (high - low) /2 ;
        while (low <= high) {
            if (target >= letters[mid]) {
                low = mid + 1;
                mid = low + (high - low) /2;
            } else {
                if (low == high) {
                    break;
                }
                high = mid;
                mid = low + (high - low) /2;
            }
        }
        if (low >= length) {
            return letters[0];
        }
        return letters[high];
    }
}
