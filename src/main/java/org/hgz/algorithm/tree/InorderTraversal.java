package org.hgz.algorithm.tree;

import com.alibaba.fastjson.JSON;
import org.hgz.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 中序遍历模板(递归形式)
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();


        recur(root, result);
        return result;

    }

    private void recur(TreeNode root, List<Integer> result) {
        if (root != null) {
            if(root.left != null) {
                recur(root.left, result);
            }

            result.add(root.val);

            if (root.right != null) {
                recur(root.right, result);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,null,2,3};

        TreeNode treeNode = TreeUtil.constructTree(nums);

        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> integers = inorderTraversal.inorderTraversal(treeNode);


        System.out.println(JSON.toJSONString(integers));

    }
}
