package org.hgz.algorithm.list;


public class RemoveElements {


    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        // 头结点删除后剩下的节点
        ListNode result = removeElements(head.next, val);
        if(head.val == val) {
            return  result;
        } else {
            head.next = result;
            return head;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};






    }


}
