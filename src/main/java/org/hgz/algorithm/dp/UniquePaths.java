package org.hgz.algorithm.dp;

/**
 * @author guozhong.huang
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }


    public int uniquePaths1(int m, int n) {
        int[] f = new int[n];

        f[0] = 1;

        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                f[j] += f[j - 1];
            }
        }

        return f[n -1];

    }



    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int i = uniquePaths.uniquePaths1(4, 4);
        System.out.println(i);
    }

}
