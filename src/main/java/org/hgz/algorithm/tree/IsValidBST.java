package org.hgz.algorithm.tree;

import org.hgz.algorithm.utils.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * BST 的终须遍历是递增的
 * 直接中序遍历,查看是否是递增
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        // 定义一个栈
        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        double inorder = -Double.MAX_VALUE;


        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }

            inorder = root.val;
            System.out.println(inorder);
            root = root.right;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.constructTree(new Integer[]{2, 1, 3});
        IsValidBST isValidBST = new IsValidBST();
        boolean validBST = isValidBST.isValidBST(treeNode);
        System.out.println(validBST);
    }
}
