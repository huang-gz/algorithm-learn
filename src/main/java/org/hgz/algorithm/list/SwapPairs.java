package org.hgz.algorithm.list;

/**
 * 两两交换
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next);
        newHead.next = head;
        return newHead;
    }
}
