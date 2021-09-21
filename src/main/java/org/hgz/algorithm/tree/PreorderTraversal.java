package org.hgz.algorithm.tree;

import org.hgz.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        recur(root, result);
        return result;
    }

    public void recur(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);

            if (root.left != null) {
                recur(root.left, result);
            }

            if (root.right != null) {
                recur(root.right, result);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.constructTree(new Integer[]{1, null, 2, 3});

        PreorderTraversal pre = new PreorderTraversal();
        List<Integer> integers = pre.preorderTraversal(treeNode);
        System.out.println(integers);


    }


}
