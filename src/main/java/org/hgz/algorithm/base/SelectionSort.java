package org.hgz.algorithm.base;

import com.alibaba.fastjson.JSON;
import org.hgz.algorithm.utils.SwapUtil;

public class SelectionSort {

    public static void selectionSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    SwapUtil.swap(i, j, nums);
                }
            }


        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 10, 1, 0, 0, 1,3,4,5};

        selectionSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
