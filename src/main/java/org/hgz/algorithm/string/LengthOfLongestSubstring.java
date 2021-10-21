package org.hgz.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int result = 0;
        int rk = -1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }

            while(rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk ++;
            }
            result = Math.max(result, rk - i + 1);
        }
        return result;
    }

}
