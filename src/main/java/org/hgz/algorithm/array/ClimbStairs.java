package org.hgz.algorithm.array;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {


    public int climbStairs(int n) {

        int[] midR = new int[n];

        return recursion(n-1, midR);
    }

    private int recursion(int n, int[] midR) {
        if (midR[n] == 0) {
            if (n <= 1) {
                midR[n] = n + 1;
            } else {
                midR[n] = recursion(n-1, midR) + recursion(n-2, midR);
            }

        }
        return midR[n];
    }




    public int climbStairs1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int[] climbCount = new int[n];
        climbCount[0] = 1;
        climbCount[1] = 2;

        if (n > 2) {
            for (int i = 2; i < n; i++) {
                climbCount[i] = climbCount[i -1] + climbCount[i-2];
            }
        }

        return climbCount[n-1];

    }


    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(2);
        System.out.println(i);
    }
}
