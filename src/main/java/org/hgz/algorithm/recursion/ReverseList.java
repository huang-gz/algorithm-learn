package org.hgz.algorithm.recursion;

import org.hgz.algorithm.list.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return result;
    }
}
