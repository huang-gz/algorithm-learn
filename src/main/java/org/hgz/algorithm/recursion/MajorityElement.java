package org.hgz.algorithm.recursion;


import java.util.jar.JarEntry;

/**
 * 典型的分治问题
 * https://leetcode-cn.com/problems/majority-element/description/
 * 某个元素的数量大于 n/2
 * 这样以来，我们就可以使用分治法解决这个问题：将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，随后在 a1 和 a2 中选出正确的众数。
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }


    private int majorityElementRec(int[] nums, int lo, int hi) {

        // base case; the only element in an array of size 1 is the majority element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice

        int mid = (hi - lo) / 2 + lo;

        int left = majorityElementRec(nums,  lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if(left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);

        int rightCount = countInRange(nums, right, lo, hi);


        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        MajorityElement majorityElement = new MajorityElement();
        int i = majorityElement.majorityElement(new int[]{3,2,3});
        System.out.println(i);
    }


}
