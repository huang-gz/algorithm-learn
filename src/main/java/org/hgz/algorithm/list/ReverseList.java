package org.hgz.algorithm.list;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public ListNode reverseList2(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    public static void main(String[] args) {

    }
}



