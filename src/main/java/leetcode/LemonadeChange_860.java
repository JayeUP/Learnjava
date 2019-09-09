package leetcode;

/*
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

示例 1：

输入：[5,5,5,10,20]
输出：true
解释：
前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
由于所有客户都得到了正确的找零，所以我们输出 true。

示例 2：

输入：[5,5,10]
输出：true
示例 3：

输入：[10,10]
输出：false
示例 4：

输入：[5,5,10,10,20]
输出：false
解释：
前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
由于不是每位顾客都得到了正确的找零，所以答案是 false。
*/
public class LemonadeChange_860 {
    public static void main(String[] args) {
        int[] bills = {5,5,10};
        boolean change = lemonadeChange(bills);
        System.out.println("canChange = " + change);

    }

    /*public static boolean lemonadeChange(int[] bills) {
        int[] value= {5,10,20};
        int[] leftCount= {0,0,0};  // 记录手头5,10,20美元的数量
        int length = bills.length;
        for (int i = 0; i < length; i++) {
            leftCount[getLoc(bills[i])]++;
            int charge = bills[i] - 5;  // 要找的钱
            if (charge > 0) {
                // 需要找零，先从面值大的开始找
                for (int j = 2; j >= 0 && charge > 0; j--) {
                    int num = charge / value[j];
                    if (num > leftCount[j]) {
                        // 如果当前数量不够找，则先将其找完
                        charge -= leftCount[j] * value[j];
                        leftCount[j] = 0;
                    } else {
                        charge -= num * value[j];
                        leftCount[j] -= num;
                    }
                }
                // 当前的钱找完，还是不满足
                if (charge > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getLoc(int bill) {
        int location = 0;
        if (bill == 5) {
            location = 0;
        } else if (bill == 10) {
            location = 1;
        } else if (bill == 20) {
            location = 2;
        }
        return location;
    }*/

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5)
                five++;
            else if (bill == 10) {
                if (five == 0)
                    return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
