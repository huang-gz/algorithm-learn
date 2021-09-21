package org.hgz.algorithm.array;

import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < nums.length ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int l = i +1;
            int r = nums.length -1;
            for (;l < r; ) {
                if (l > i + 1 && nums[l] == nums[l - 1]){
                    l++;
                    continue;
                }
                int tmp = nums[l] + nums[r];
                if (tmp == target) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    continue;
                }

                if (tmp > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        List<List<Integer>> lists = threeSum.threeSum(new int[]{0,0,0,0});


        System.out.println(JSON.toJSONString(lists));
    }
}
