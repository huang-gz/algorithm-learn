package org.hgz.algorithm.dp;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/
 * 收集雨水
 */
public class Trap {
    /**
     * 收集雨水, 采用动态规划的方式实现
     *
     * @param height
     * @return
     */
    @Deprecated
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 1; i < n - 1; i++) {
            int tempResult = Math.min(leftMax[i], rightMax[i]) - height[i];
            result += tempResult > 0 ? tempResult : 0;
        }
        return result;

    }

    /**
     * 测试 验证 收集雨水
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        // 记录这个点的左边的最大值
        // 记录 index 的右侧最大值

        // 该点能存的水为 左最大值 右最大值中较小的   再 减去当前的高度

        // 计算 1 到 n- 2 的所有能存水的值 累加

        int n = height.length;
        int[] leftMax = new int[n - 1];
        int[] rightMax = new int[n - 1];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        int result = 0;


        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = n - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }


        for (int i = 1; i < n-1 ; i++) {
            int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
            result += Math.max(temp, 0);
        }

        return result;

    }

}
