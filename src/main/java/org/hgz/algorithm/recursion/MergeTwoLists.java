package org.hgz.algorithm.recursion;

import org.hgz.algorithm.list.ListNode;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 退出条件
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // 划分子问题
        // l1 的值小于 l2 的值, 则就是 l1.next 和 l2 合并
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 引入哑节点
        ListNode prehead = new ListNode();
        prehead.val = -1;

        ListNode prev = prehead;

        while(l1 != null && l2 != null) {
            // 暴力解法, 移动 prev 和 较小的都往前移动一位
            if (l1.val < l2.val) {

                prev.next = l1;

                l1 = l1.next;

            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }

        return prehead.next;

    }





}
