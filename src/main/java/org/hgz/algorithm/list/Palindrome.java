package org.hgz.algorithm.list;


/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class Palindrome {

    public boolean isPalindrome(ListNode head) {
        // 1. 找到中点

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode newHead = reverseList(p1);

        p1 = head;
        p2 = newHead;


        boolean isPalindrome = true;
        while (isPalindrome && p2 != null && p1 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return isPalindrome;
    }


    ListNode left;
    public boolean isPalindrome2(ListNode head) {
        // 判断 list 是否是回文字符串
        left = head;
        return traverse(head);
    }

    // 后序遍历
    boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean res = traverse(right.next);

        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 1};

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        Palindrome palindrome = new Palindrome();
        boolean result = palindrome.isPalindrome2(dummy.next);
        System.out.println(result);

    }

}
