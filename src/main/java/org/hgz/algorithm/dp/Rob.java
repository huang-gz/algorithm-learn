package org.hgz.algorithm.dp;


/**
 * 打家劫舍问题
 */
public class Rob {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] a = new int[n][2];
        a[0][1] = nums[0];


        for (int i = 1; i < n; i++) {

            a[i][0] = Math.max(a[i - 1][0], a[i-1][1]);
            a[i][1] = a[i-1][0] + nums[i];
        }

        return Math.max(a[n-1][1], a[n-1][0]);
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int rob1 = rob.rob(new int[]{2,7,9,3,1});
        System.out.println(rob1);
    }
}
