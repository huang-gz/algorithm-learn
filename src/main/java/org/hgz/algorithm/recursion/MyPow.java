package org.hgz.algorithm.recursion;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class MyPow {


    public double myPow(double x, int n) {

        return  n > 0 ? recurPow(x, n) : 1.0 / recurPow(x, -n);
    }

    public double recurPow(double x, int n) {
        // 终止条件
        if (n == 0) {
            return 1.0;
        }

        // 下一层
        double v = myPow(x, n/2);

        // 结果 merge 分支归并 思想
        return n % 2 == 0 ? v * v : v * v * x;
    }


    public static void main(String[] args) {
        // 分治 回溯

        MyPow myPow = new MyPow();

        double v = myPow.myPow(2, 2);
        System.out.println(v);

    }

}
