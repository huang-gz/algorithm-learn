package org.hgz.algorithm.dp;

public class FibonacciDemo {

    // 普通递归
    public int fib(int n) {
       if (n < 2) {
           return n;
       }
        // 没吃药层都 *2 所以是指数级 O(2^n)
       return fib(n-1) + fib(n-2);
    }


    // 带有缓存的递归
    public int fib2(int n, int[] nums) {
        // 记忆话搜索, 加一个缓存 O(n)
        if (n < 2) {
            return n;
        }
        // 已经计算过就不用再计算了
        if (nums[n] == 0) {
            nums[n] = fib2(n-1, nums) + fib2(n-2, nums);
        }


        return nums[n];
    }


    // 动态规划  f(x) = f(x-1) + f(x-2);
    // 严格意义上说 斐波拉切数列不算动态规划, 因为其不存在求最值
    // 状态压缩
    public int fibdp(int n) {
        if (n < 2) {
            return n;
        }
        int x = 0;
        int y = 0;
        int r = 1;
        // 状态压缩, 只记录必要的信息
        for(int i = 2; i<= n; i++) {
            x = y;
            y = r;
            r = x + y;
        }
        return r;
    }


    public static void main(String[] args) {
        FibonacciDemo fibonacciDemo = new FibonacciDemo();
        int fib = fibonacciDemo.fibdp(5);
        System.out.println(fib);
    }


}
