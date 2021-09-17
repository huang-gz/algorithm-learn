package org.hgz.algorithm.array;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {


        for (int i =0, j=0; i < nums.length; i++) {

            if (nums[i] != 0) {
                // 和 0 交换
                if(i == j) {
                    j++;
                } else {
                    nums[j++] = nums[i];
                    nums[i] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);

        System.out.println(JSON.toJSONString(nums));

    }
}
