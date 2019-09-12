package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。

对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。

示例 1：

输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
输出：["girl","student"]
示例 2：

输入：text = "we will we will rock you", first = "we", second = "will"
输出：["we","rock"]
*/
public class FindOcurrences_1078 {
    public static void main(String[] args) {
        String text = "jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa";
        String first = "kcyxdfnoa";
        String second = "jkypmsxd";
        String[] strings = findOcurrences(text, first, second);
        System.out.println("strings = " + Arrays.toString(strings));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> list = new ArrayList<>();
        /*String firAndSec = first +" "+ second+" ";
        int length = firAndSec.length();

        int fromIndex = 0;
        while ((fromIndex = text.indexOf(firAndSec, fromIndex)) != -1) {
            String s = text.substring(fromIndex + length, text.indexOf(" ", fromIndex + length) != -1 ? text.indexOf(" ", fromIndex + length) : text.length());
            list.add(s);
            fromIndex += length;
        }*/

        String[] words = text.split(" ");
        for (int i = 0; i < words.length-2; i++) {
            if (words[i].equals(first) && words[i+1].equals(second)) {
                list.add(words[i+2]);
            }
        }

        String[] strings= new String[list.size()];
        list.toArray(strings);
        return strings;
    }
}
