package leetcode;


import java.util.HashMap;

public class IntersectionList_160 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 遍历两个链表，得出长度
        int lengthA = 0;
        int lengthB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while (p != null) {
            lengthA++;
            p = p.next;
        }
        while (q != null) {
            lengthB++;
            q = q.next;
        }

        // 将链表的长度作为key，链表头结点作为value。做个映射
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(lengthA, headA);
        map.put(lengthB, headB);

        ListNode longList = null;
        ListNode shortList = null;
        if (map.size() == 1) {
            // 两个链表等长时
            longList = headA;
            shortList = headB;
        } else {
            // 两个链表不等长时
            longList = map.get(Math.max(lengthA, lengthB));
            shortList = map.get(Math.min(lengthA, lengthB));
        }
        // 将长链表的工作指针先往后移动 两个长度差值 的位数，保证后面比较的长度等长
        int minus = Math.abs(lengthA - lengthB);
        for (int i = 0; i < minus; i++) {
            longList = longList.next;
        }

        // 同步比较两个链表的当前节点是否相同
        while (longList != shortList && longList != null && shortList != null) {
            longList = longList.next;
            shortList = shortList.next;
        }

        return longList;
    }
}
