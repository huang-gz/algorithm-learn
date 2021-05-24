package org.hgz.algorithm;

import com.alibaba.fastjson.JSON;

public class MoveZeroesSolution {

    public static void moveZeroes(int[] nums) {
        int k = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    nums[k++] = nums[i];
                    nums[i] = 0;
                } else {
                    k++;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        moveZeroes(nums);

        System.out.println(JSON.toJSONString(nums));
    }

}
