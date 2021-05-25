package org.hgz.algorithm;

public class MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {

        int l = 0;
        int r = -1;
        int sum = 0;

        int res = nums.length + 1;

        while(l < nums.length) {
            if (r + 1 < nums.length && sum < target) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= target) {
                res = Math.min(res, r-l + 1);
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 1;

        System.out.println(minSubArrayLen(6, nums));
    }
}
