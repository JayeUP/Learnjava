package leetcode;

import java.util.Stack;

/**
 * @author: jinyuan
 * @since: 2019/10/29 10:45
 */
/*
给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例:
输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出: 7 -> 8 -> 0 -> 7
*/
public class AddTwoNumbers_445 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode p = l1;
        p.next = new ListNode(3);
        /*p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;*/

        ListNode l2 = new ListNode(0);
        p = l2;
        /*p.next = new ListNode(6);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;*/

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println("result = " + result.val);
            result = result.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 双栈法
        ListNode result = new ListNode(-1);
        ListNode p = l1;
        Stack<Integer> s1 = new Stack<>();
        ListNode q = l2;
        Stack<Integer> s2 = new Stack<>();
        while (p != null) {
            s1.push(p.val);
            p = p.next;
        }
        while (q != null) {
            s2.push(q.val);
            q = q.next;
        }

        int carry = 0;
        while (!s1.empty() || !s2.empty()) {
            int temp = 0;
            if (!s1.empty()) {
                temp += s1.pop();
            }
            if (!s2.empty()) {
                temp += s2.pop();
            }
            temp += carry;
            carry = temp /10;
            ListNode first = new ListNode(temp %10);
            first.next = result.next;
            result.next = first;
        }

        if (carry > 0) {
            ListNode first = new ListNode(carry);
            first.next = result.next;
            result.next = first;
        }
        return result.next;
    }

    /*public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode p = l1;
        ListNode q = l2;

        int carry = 0;
        while (p != null && q != null) {
            int temp = p.val + q.val + carry;
            carry = temp / 10;
            p.val = temp % 10;
            q.val = temp % 10;

            p = p.next;
            q = q.next;
        }
        ListNode result = new ListNode(-1);
        if (p != null) {
            while (p != null) {
                int temp = p.val + carry;
                carry = temp / 10;
                p.val = temp % 10;

                p = p.next;
            }
            result = reverseList(l1);
        } else if (q != null) {
            while (q != null) {
                int temp = q.val + carry;
                carry = temp / 10;
                q.val = temp % 10;

                q = q.next;
            }
            result = reverseList(l2);
        } else {
            result = reverseList(l1);
        }

        if (carry > 0) {
           ListNode lastOne= new ListNode(carry);
           lastOne.next = result;
           result = lastOne;
        }
        return result;
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
    }*/
}


