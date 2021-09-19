package org.hgz.algorithm.sort;

import com.alibaba.fastjson.JSON;
import org.hgz.algorithm.utils.SwapUtil;

public class BubbleSort {


    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    SwapUtil.swap(j, j + 1, nums);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,1,3,2,9};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
