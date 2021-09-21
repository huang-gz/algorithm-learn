package org.hgz.algorithm.base;

import com.sun.tools.javac.util.Assert;

public class BinarySearch {

    public static int binarySearch(int[] arr, int n, int target) {

        // [] 左右都为闭区间
        int l = 0, r = n -1;

        while (l <=r ) {
            // l + r 容易整形溢出
            int mid = l + (r -l)/2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 1000;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        int result = binarySearch(arr, n, n / 2);

        Assert.check(result == n/2);


    }
}
