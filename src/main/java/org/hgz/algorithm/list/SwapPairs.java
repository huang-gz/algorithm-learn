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

    public ListNode swapPair2(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode temp = dummyNode;

        while(temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dummyNode.next;



    }
}
