package leetcode;
/*给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)

注意：
你可以假设两个字符串均只含有小写字母。

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
public class CanConstruct_383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean construct = canConstruct(ransomNote, magazine);
        System.out.println("construct = " + construct);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder builder = new StringBuilder(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            String s = ransomNote.substring(i,i+1);
            int index = builder.indexOf(s);
            if (index == -1) {
                return false;
            }
            builder.setCharAt(index,'1');
        }
        return true;
    }
}
