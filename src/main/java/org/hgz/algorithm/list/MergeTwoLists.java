package org.hgz.algorithm.list;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);

        ListNode temp = newHead;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                temp.next = p2;
                temp = p2;
                p2 = p2.next;
            } else {
                temp.next = p1;
                temp = p1;
                p1 = p1.next;
            }
        }

        if (p1 != null) {
            temp.next = l1;
        }
        if (p1 != null) {
            temp.next = l2;
        }

        return newHead.next;

    }
}
