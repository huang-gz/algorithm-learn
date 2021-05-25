package org.hgz.algorithm.utils;

public class SwapUtil {

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
}
