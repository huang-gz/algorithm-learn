package org.hgz.algorithm.list;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    // 暴力解法使用 HashSet, 只要第一个存在的就是环的入口
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> visited = new HashSet<>();
        ListNode pos = head;

        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;

        }
        return null;
    }
}
