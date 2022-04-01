package org.hgz.algorithm.list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guozhong.huang
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null ) {
            return null;
        }
        if (!cache.containsKey(head)) {
            Node newNode = new Node(head.val);
            cache.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }




}
