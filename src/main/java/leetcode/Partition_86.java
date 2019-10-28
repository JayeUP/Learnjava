package leetcode;

/**
 * @author: jinyuan
 * @since: 2019/10/28 15:04
 */

/*
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
你应当保留两个分区中每个节点的初始相对位置。

示例:
输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
*/
public class Partition_86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(2);

        ListNode partition = partition(head, 3);
        while (partition != null) {
            System.out.println("partition = " + partition.val);
            partition = partition.next;
        }

    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 遍历一遍链表，将大于等于x的节点拿出来 组成新的一个链表，小于x的节点保留
        // 然后将由大数组成的新链表 接到原链表的尾部即可
        ListNode result  = new ListNode(-1);    // 小于x的链表头结点
        result.next = head;
        ListNode big = new ListNode(-1);    // 大于等于x的链表头结点
        ListNode tail = big;
        ListNode p = head;    // 工作指针，从第一个遍历到最后一个
        ListNode q = result;  // p的上一个节点，指向p
        while (p!=null) {
            if (p.val >= x) {
                // 当前值>=x ，则将该节点放入big的末尾，并将其从原链表摘除
                q.next = p.next;

                tail.next = p;
                tail = tail.next;
                tail.next = null;

                p = q.next;
            } else {
                // 当前值<x，则不做处理，继续遍历
                q = p;
                p = p.next;
            }
        }
        // 将大数链表 接到 小数链表的尾部
        q.next = big.next;
        return result.next;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
