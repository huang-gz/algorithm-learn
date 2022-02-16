package org.hgz.algorithm.stack;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CQueue {
    // Deque 音译:dike 双端队列
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }
}
