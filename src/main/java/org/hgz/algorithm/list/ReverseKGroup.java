package org.hgz.algorithm.list;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/submissions/
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyNode = new ListNode(0);

        dummyNode.next = head;

        ListNode tail = head;
        ListNode pre = dummyNode;


        while(tail.next != null) {

            for (int i = 0; i < k; i++) {
                if (tail == null) {
                    return dummyNode.next;
                }
                tail = tail.next;
            }

            ListNode[] listNodes = myReverse(head, tail);

            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            pre = tail;
            head = pre.next;
        }
        return dummyNode.next;

    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode[] listNodes = new ListNode[2];


        ListNode temp = head;

        while(temp != tail) {

            ListNode next = temp.next;
            temp.next = next.next;
            next.next = temp;
            temp = next;

        }

        listNodes[0] = temp;
        listNodes[1] = head;
        return listNodes;
    }
}
