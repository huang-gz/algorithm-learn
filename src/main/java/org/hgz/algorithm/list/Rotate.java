package org.hgz.algorithm.list;

import com.alibaba.fastjson.JSON;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Rotate {

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        int[] newArr = new int[n];

        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }

        System.arraycopy(newArr, 0, nums, 0, n);
    }



    public void rotate1(int[] nums, int k) {

        int n = nums.length;
        int[] newArr = new int[n];

        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }

        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void main(String[] args) {
//        nums = [1,2,3,4,5,6,7], k = 3

        Rotate rotate = new Rotate();
        int[] nums = new int[] {1,2,3,4,5,6,7};
        rotate.rotate(nums, 3);


        System.out.println(JSON.toJSONString(nums));

    }
}
