package leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/*假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

示例 1:

输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。
示例 2:

输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
*/
public class FindRestaurant_599 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] commonHobby = findRestaurant(list1, list2);
        System.out.println("commonHobby = " + Arrays.toString(commonHobby));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int j = 0; j < list2.length; j++) {
            String s2 = list2[j];
            if (map.get(s2) != null) {
                map.put(s2, (map.get(s2) + j));
                int indexSum = map.get(s2);
                if (indexSum < minIndex) {
                    minIndex = indexSum;
                    list.clear();
                }
                if (indexSum == minIndex) {
                    list.add(s2);
                }
            }
        }

        String[] strings = new String[list.size()];
        return list.toArray(strings);
    }
}
