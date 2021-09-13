package org.hgz.algorithm;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class MaxArea11 {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while(left < right) {
            int le = height[left];
            int ri = height[right];
            int area = Math.min(le, ri) * (right - left);
            maxArea = area > maxArea ? area : maxArea;
            // 高度低的那个往里挪(往中间挪)
            if (le <= ri) {

                while(height[left] < le && left < right) {
                    left++;
                }

            } else {
                while(height[right] < ri && right > left) {
                    right --;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4,3,2,1,4};
        MaxArea11 maxArea11 = new MaxArea11();
        int i = maxArea11.maxArea(height);
        System.out.println(i);
    }
}
