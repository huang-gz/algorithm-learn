package org.hgz.algorithm.list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }




    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode newListNode (int[] nums) {
        if (nums.length == 0) {
            return new ListNode(-1);
        }
        ListNode head = new ListNode(nums[1]);

        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return head;


    }
}
