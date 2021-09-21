package org.hgz.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        recur(root, 0, result);
        return result;

    }

    public void recur(Node root, int leve, List<List<Integer>> result) {
        if (root != null) {

            if(result.size() <= leve) {
                result.add(new ArrayList<>());
            }
            result.get(leve).add(root.val);

            for(Node chilren : root.children) {
                recur(chilren, leve + 1, result);
            }

        }

    }


}
