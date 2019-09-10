package leetcode;

/*给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
*/
public class FirstUniqChar_387 {
    public static void main(String[] args) {
        String s = "leetcode";
        int uniqChar = firstUniqChar(s);
        System.out.println("uniqChar = " + uniqChar);

    }

    public static int firstUniqChar(String s) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            String s1 = builder.substring(i, i + 1);
            int lastIndex = builder.lastIndexOf(s1);
            int firstIndex = builder.indexOf(s1);
            if (firstIndex == lastIndex) {
                return i;
            }
        }
        return -1;
    }
}
