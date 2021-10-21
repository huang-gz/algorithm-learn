package org.hgz.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    public void recursion(List<List<Integer>> result, int deep, List<Integer> curList, int[] nums) {
        if (deep == nums.length) {
            result.add(curList);
            return;
        }
        if (curList == null) {
            curList = new ArrayList<>();
        }
        curList.add(nums[deep]);
        recursion(result, deep + 1, curList, nums);
        curList.remove(deep);
        recursion(result, deep + 1, curList, nums);
    }
}


/**
 * 官方题解
 */
class Solution {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}

