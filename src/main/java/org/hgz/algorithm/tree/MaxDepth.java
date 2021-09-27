package org.hgz.algorithm.tree;

import org.hgz.algorithm.utils.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

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

    public int maxDepthBFS(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        int result = 0;

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8};
        TreeNode root = TreeUtil.constructTree(nums);


        MaxDepth maxDepth = new MaxDepth();
        int i = maxDepth.maxDepthBFS(root);
        System.out.println(i);


    }

}
