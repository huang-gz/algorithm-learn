package org.hgz.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }

        Set<Integer> result = new HashSet<>();
        for(int i = 0; i< nums2.length; i++) {
            if (record.contains(nums2[i])) {
                result.add(nums2[i]);
            }

        }
        int[] resultArray = new int[result.size()];

        int i = 0;
        for (Integer ins: result) {
            resultArray[i++] = ins;
        }
        return resultArray;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(record.containsKey(nums1[i])) {
                record.put(nums1[i], (record.get(nums1[i]) + 1) );
            } else {
                record.put(nums1[i], 1);
            }
        }

        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {

        }



    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,2, 1};
        int[] nums2 = {2,2};

        int[] intersection = intersection(nums1, nums2);
        System.out.println(JSON.toJSONString(intersection));
    }
}
