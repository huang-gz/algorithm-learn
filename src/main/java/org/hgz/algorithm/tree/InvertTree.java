package org.hgz.algorithm.tree;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/submissions/
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {

            if (root.left != null) {
                invertTree(root.left);
            }

            if (root.right != null) {
                invertTree(root.right);
            }

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        return root;
    }
}
