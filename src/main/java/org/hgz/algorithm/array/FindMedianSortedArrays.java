package org.hgz.algorithm.array;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并两个数组
        int m = nums1.length;
        int n = nums2.length;

        int[] nums = new int[n + m];

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2;
            } else {
                return nums2[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (n + m)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if ((m + n) % 2 == 0) {
            return (nums[(m + n) / 2 - 1] + nums[(m + n) / 2]) / 2;
        } else {
            return nums[(m + n) / 2];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2};

        int[] nums2 = {3,4};

        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);


    }


    private static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] A;
            int[] B;
            if (nums1.length > nums2.length) {
                A = nums2;
                B = nums1;
            } else {
                A = nums1;
                B = nums2;
            }
            int m = A.length;
            int n = B.length;

            int maxLeft = 0;
            int minRight = 0;

            int iMin = 0;
            int iMax = m;

            int halfLength = (m + n + 1) / 2;

            int i,j;
            while (iMin <= iMax) {
                i = (iMin + iMax) / 2;
                j = halfLength - i;

                // 二分查找
                if( i < m && B[j-1] > A[i]) {
                    iMin = i + 1;
                } else if (i > 0 && A[i - 1] > B[j]) {
                    iMax = i -1;
                } else {
                    if (i == 0) {
                        maxLeft = B[j -1];
                    } else if (j == 0) {
                        maxLeft = A[i-1];
                    } else {
                        maxLeft = Math.max(A[i-1], B[j-1]);
                    }

                    if ((m + n) % 2 == 1) {
                        return  maxLeft;
                    }

                    if (i == m) {
                        minRight = B[j];
                    } else if (j == n) {
                        minRight = A[i];
                    } else {
                        minRight = Math.min(A[i], B[j]);
                    }
                    return  ((maxLeft + minRight) / 2.0);
                }
            }
            return -1;
        }

    }


}
