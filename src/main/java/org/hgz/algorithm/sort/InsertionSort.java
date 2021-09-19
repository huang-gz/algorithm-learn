package org.hgz.algorithm.sort;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import org.hgz.algorithm.utils.SwapUtil;

public class InsertionSort {
    public void insertionSort(int[] nums) {
        //向已经排序的数组里插入排序
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    SwapUtil.swap(j, j-1, nums);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,1,3,2,9};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
