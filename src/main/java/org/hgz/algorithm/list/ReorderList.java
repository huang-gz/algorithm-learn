package org.hgz.algorithm.list;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. 找中间节点

        ListNode mid = findMid(head);

        ListNode l1 = head;

        ListNode l2 = mid.next;
        mid.next = null;

        // 2. 翻转从中间到最后的节点
        l2 = revertList(l2);

        // 3. 合并两个链表
        mergeList(l1, l2);
    }

    public ListNode findMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode revertList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newNode = revertList(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode tempL1;
        ListNode tempL2;

        while(l1 != null && l2 != null) {
            tempL1 = l1.next;
            tempL2 = l2.next;

            l1.next = l2;
            l1 = tempL1;

            l2.next = l1;
            l2 = tempL2;

        }
    }


}
