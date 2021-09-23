package org.hgz.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 * 双指针, 和三数和是一个原理
 */
public class FourSum {


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0; i < n - 4; i++) {
            int temp1 = target - nums[i];
            for(int j = i+1; j < n - 3; j++) {
                int temp2 = temp1 - nums[j];
                int l = j + 1;
                int r= nums.length -1;

                while(l < r) {

                    if (nums[l] + nums[r] > temp2) {
                        r--;
                    }

                    if (nums[l] + nums[r] == temp2) {
                        res.add(Arrays.asList(nums[i], nums[j] ,nums[l], nums[r]));
                        r--;
                    }
                    if (nums[l] + nums[r] < temp2) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
