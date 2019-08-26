package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersion_165 {
    public static void main(String[] args) {
        String version1 = "1";
        String version2 = "1.1";
        int res = compareVersion(version1, version2);
        System.out.println("res = " + res);
    }

    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");    // 注意要加\\才行
        String[] split2 = version2.split("\\.");
        List<Integer> list1 = Arrays.asList(split1).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        List<Integer> list2 = Arrays.asList(split2).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        int size1 = list1.size();
        int size2 = list2.size();

        int max = Math.max(size1, size2);
        // 以较长的数组长度 为比较次数
        for (int i = 0; i < max; i++) {
            // 如果某数组已经越界，则其值作为0
            Integer num1 = (i >= size1) ? 0 : list1.get(i);
            Integer num2 = (i >= size2) ? 0 : list2.get(i);
            if (num1 == num2) {
                continue;
            } else if (num1 > num2) {
                return 1;
            } else {
                return -1;
            }
        }
        // 一直比较到最后都相等
        return 0;
    }
}
