package org.hgz.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }


    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    private int capacity;
    private int size;
    private DLinkedNode head;
    private DLinkedNode tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;

    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode dLinkedNode = new DLinkedNode(key, value);
            cache.put(key, dLinkedNode);
            ++size;
            if (size > capacity) {
                --size;
                DLinkedNode dLinkedNode1 = removeTail();
                cache.remove(dLinkedNode1.key);
            }
            addToHead(dLinkedNode);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }



}
