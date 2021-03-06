package leetcode;

/**
 * @author: jinyuan
 * @since: 2019/10/28 20:56
 */
/*
给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。

注意:
输入只包含小写英文字母。
输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
输入字符串的长度小于 50,000。

示例 1:
输入: "owoztneoer"
输出: "012" (zeroonetwo)

示例 2:
输入: "fviefuro"
输出: "45" (fourfive)
*/

// 0~9
// zero, one, two, three, four, five, six, seven, eight, nine
public class OriginalDigits_423 {
    public static void main(String[] args) {
        String s = "owoztneoer";
        String result = originalDigits(s);
        System.out.println("result = " + result);
    }

    public static String originalDigits(String s) {
        return "";
    }
}
