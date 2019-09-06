package leetcode;

/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class isPalindrome_234 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean palindrome = isPalindrome(node1);
        System.out.println("palindrome = " + palindrome);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        // 遍历一遍链表，将后半段链表进行逆序
        ListNode p = head;      //
        ListNode mid = head;    // mid指向中间节点
        int length = 0;
        while(p!= null) {
            length ++;
            if (length % 2 == 0) {
                mid = mid.next;
            }
            p = p.next;
        }

        // 总长度是奇数
        if (length % 2 == 1) {
            mid = mid.next;
        }

        // 逆序mid开始的 链表
        mid = reverseList(mid);
        p = head;
        while (mid != null) {
            if (p.val != mid.val) {
                return false;
            }
            mid = mid.next;
            p = p.next;
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        //采用头插法
        ListNode newHead=new ListNode(0);
        ListNode p = head;
        ListNode q = null;
        while(p!=null){
            q = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p=q;
        }
        return newHead.next;
    }

}
