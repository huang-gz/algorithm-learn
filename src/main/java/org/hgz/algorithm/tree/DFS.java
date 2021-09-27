package org.hgz.algorithm.tree;

import com.alibaba.fastjson.JSON;
import org.hgz.algorithm.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索
 * 打印每一层
 */
public class DFS {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> allResults = new ArrayList<>();

        if (root == null) {

            return allResults;

        }

        travel(root, 0, allResults);

        return allResults;

    }

    private void travel(TreeNode root, int level, List<List<Integer>> results) {

        if (results.size() == level) {

            results.add(new ArrayList<>());

        }

        results.get(level).add(root.val);

        if (root.left != null) {

            travel(root.left, level + 1, results);

        }

        if (root.right != null) {
            travel(root.right, level + 1, results);

        }

    }


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12};

        TreeNode treeNode = TreeUtil.constructTree(nums);


        DFS dfs = new DFS();
        List<List<Integer>> lists = dfs.levelOrder(treeNode);

        System.out.println(JSON.toJSONString(lists));


    }
}
