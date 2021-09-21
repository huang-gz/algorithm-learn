package org.hgz.algorithm.recursion;

public class ClimbStairs {

    public int climbStairs(int n) {
        int[] midR = new int[n];
        return recursion(n-1, midR);
    }

    private int recursion(int n, int[] midR) {
        if (midR[n] != 0) {
            return midR[n];
        }
        if(n <=1) {
            midR[n] = n + 1;
            return n + 1;
        }

       int result = recursion(n -1 , midR) + recursion(n -2, midR);
        midR[n] = result;
        return result;
    }


}
