package org.hgz.algorithm.sort;

import com.alibaba.fastjson.JSON;
import org.hgz.algorithm.utils.SwapUtil;

public class SelectionSort {

    public void selectonSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            SwapUtil.swap(min, i, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,1,3,2,9};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectonSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
