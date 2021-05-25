package org.hgz.algorithm;

import com.alibaba.fastjson.JSON;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while(l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[] {l +1, r +1};
            }
            if (nums[l] + nums[r] > target) {
                r --;
            } else {
                l ++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] ints = twoSum(nums, target);
        System.out.println(JSON.toJSONString(ints));

    }
}
