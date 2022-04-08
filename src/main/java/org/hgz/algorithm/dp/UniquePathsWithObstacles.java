package org.hgz.algorithm.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * <p>
 * <p>
 * 可以转换成分治问题, 最近最简重复性
 * 自顶向下是分治递归
 */
public class UniquePathsWithObstacles {

    // opt[i, j] = opt[i, j+1] + opt[i+1, j];

    // 用一个二维数组记录他的路径和
    // 状态转移方程, 动态规划方程
    // 完整逻辑

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowCount = obstacleGrid.length;
        int columnCount = obstacleGrid[0].length;
        int[][] opt = new int[rowCount][columnCount];

        boolean columnZero = false;
        // 初始化最后一行和一列的路径, 放入 opt 数组中
        for (int i = rowCount - 1; i >= 0; i--) {
            if (obstacleGrid[i][columnCount - 1] == 1 || columnZero) {
                opt[i][columnCount - 1] = 0;
                columnZero = true;
            } else {
                opt[i][columnCount - 1] = 1;
            }
        }


        boolean rowZero = false;
        for (int i = columnCount - 1; i >= 0; i--) {
            if (obstacleGrid[rowCount - 1][i] == 1 || rowZero) {
                opt[rowCount - 1][i] = 0;
                rowZero = true;
            } else {
                opt[rowCount - 1][i] = 1;
            }
        }


        for (int row = rowCount - 2; row >= 0; row--) {

            for (int column = columnCount - 2; column >= 0; column--) {
                if (obstacleGrid[row][column] == 1) {
                    opt[row][column] = 0;
                } else {
                    opt[row][column] = opt[row + 1][column] + opt[row][column + 1];
                }
            }
        }

        return opt[0][0];
    }


    /**
     * 不同路径问题
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }

                if (j -1 >=0 && obstacleGrid[i][j-1] == 0) {
                    f[j] += f[j-1];
                }
            }
        }

        return f[f.length-1];


    }


    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 0}, {0, 0}};
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int i = uniquePathsWithObstacles.uniquePathsWithObstacles2(obstacleGrid);
        System.out.println(i);
    }


}
