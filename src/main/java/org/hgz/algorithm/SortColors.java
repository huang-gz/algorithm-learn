package org.hgz.algorithm;

import com.alibaba.fastjson.JSON;

public class SortColors {

    public static void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] ++;
        }


        int index = 0;
        for(int i = 0; i < count.length; i ++) {
            for(int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }


    public static void sortColors1(int[] nums) {
        int zero = -1;
        int two = nums.length;

        for (int i = 0; i < two; ) {
            if (nums[i] == 0 && ++zero != i) {
                swap(nums, i, zero);
                continue;
            }

            if (nums[i] == 2) {
                swap(nums, i, --two);
                continue;
            }

            i++;
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};
        sortColors1(nums);

        System.out.println(JSON.toJSONString(nums));
    }
}
