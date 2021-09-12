package org.hgz.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        dfs(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int index) {

        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 不选
        dfs(result, nums, list, index + 1);

        // 选
        list.add(nums[index]);
        dfs(result, nums, list, index + 1);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        SubSets subSets = new SubSets();
        List<List<Integer>> subsets = subSets.subsets(nums);

        System.out.println(JSON.toJSONString(subsets));

    }

}
