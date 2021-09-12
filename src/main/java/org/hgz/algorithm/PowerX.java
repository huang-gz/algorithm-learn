package org.hgz.algorithm;

public class PowerX {

    public double myPower(double x, int n) {
        long N = n;
        // 正数 负数 的不同处理
        return N > 0 ? quickMul(x , N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = quickMul(x, N/2);

        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        PowerX powerX = new PowerX();

        double v = powerX.myPower(2, 10);
        System.out.println(v);
        System.out.println(1/2);
    }
}
