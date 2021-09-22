package org.hgz.algorithm.recursion;

public class Multiply {


    public int multiply(int A, int B) {
        if (B == 1) {
            return A;
        }
        return A + multiply(A, B-1);
    }

    public static void main(String[] args) {
        Multiply m = new Multiply();
        int multiply = m.multiply(10, 100);
        System.out.println(multiply);
    }



}
