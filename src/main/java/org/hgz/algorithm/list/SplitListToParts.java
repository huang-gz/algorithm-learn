package org.hgz.algorithm.list;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 */
public class SplitListToParts {


    public ListNode[] splitListToParts(ListNode head, int k) {

        int n = 0;
        ListNode temp = head;

        while(temp != null) {
            n++;
            temp = temp.next;
        }

        int quotient = n/k;
        int remainder = n % k;

        ListNode[] parts = new ListNode[k];

        ListNode cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            parts[i] = cur;
            int partSize = quotient + (i < remainder ?  1 : 0);

            for (int j = 1; j < partSize ; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;

        }
        return parts;

    }

    public static void main(String[] args) {



    }



}
