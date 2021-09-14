package org.hgz.algorithm.base;

import com.alibaba.fastjson.JSON;
import org.hgz.algorithm.utils.SwapUtil;

public class InsertionSort {

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for(int j = i; j > 0; j--) {
                if (nums[j] <= nums[j-1]) {
                    SwapUtil.swap(j, j -1, nums);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 10, 1, 0, 0, 1,3,4,5};

        insertionSort(nums);
        System.out.println(JSON.toJSONString(nums));

    }
}
