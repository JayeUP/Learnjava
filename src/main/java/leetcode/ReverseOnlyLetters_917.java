package leetcode;
/*给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。

示例 1：

输入："ab-cd"
输出："dc-ba"
示例 2：

输入："a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"
示例 3：

输入："Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
*/
public class ReverseOnlyLetters_917 {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        String res = reverseOnlyLetters(s);
        System.out.println("res = " + res);
    }

    /* if (ch>=65 && ch<=90) {
            System.out.println(ch+" 是 "+"大写字母");
        }else if (ch>=97 && ch<=122) {
            System.out.println(ch+" 是 "+"小写字母");
        }*/
    public static String reverseOnlyLetters(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }
        int low = 0;
        int high = S.length()-1;
        StringBuilder builder = new StringBuilder(S);
        while (low < high) {
            // 找出前后两者的要调换的字母位置
            while (low<high && (builder.charAt(low)<65 || (builder.charAt(low)>90 && builder.charAt(low)<97) || builder.charAt(low)>122)) {
                low ++;
            }
            while (high>low && (builder.charAt(high)<65 || (builder.charAt(high)>90 && builder.charAt(high)<97) || builder.charAt(high)>122)) {
                high --;
            }

            // 交换两者
            if (low < high) {
                char lchar = builder.charAt(low);
                char hchar = builder.charAt(high);
                builder.setCharAt(low,hchar);
                builder.setCharAt(high,lchar);
                low ++;
                high --;
            }
        }
        return builder.toString();
    }
}
