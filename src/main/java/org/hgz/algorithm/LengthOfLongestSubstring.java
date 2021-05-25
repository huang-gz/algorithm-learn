package org.hgz.algorithm;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int freq[] = new int[256];

        int l = 0;
        int r = -1;

        int res = 0;

        while( l < s.length()) {
            if ( r + 1 < s.length() && freq[chars[r + 1]] == 0) {
                freq[chars[++r]] ++;
            } else {
                freq[chars[l++]] --;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        String s = "abcdefgzabc";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }


}
