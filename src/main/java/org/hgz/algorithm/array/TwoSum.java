package org.hgz.algorithm.array;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                result[0] = hashMap.get(nums[i]);
                result[1] = i;
                return result;
            }
            hashMap.put(target - nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] ints = twoSum(nums, target);
        System.out.println(JSON.toJSONString(ints));

    }
}
