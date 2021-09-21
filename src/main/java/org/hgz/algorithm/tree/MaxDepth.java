package org.hgz.algorithm.tree;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 不要人肉递归
 * 左子树, 右子树最大值 + 1
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeft = maxDepth(root.left);

        int maxRight = maxDepth(root.right);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
