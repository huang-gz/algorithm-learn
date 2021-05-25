package org.hgz.algorithm;

public class Palindrome {

    public static boolean isPalindrome(String s) {

        char[] chars = s.toLowerCase().toCharArray();

        int l = 0;
        int r = chars.length - 1;
        while(l < r) {
            if (!Character.isLetterOrDigit(chars[l])) {
                l ++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[r])) {
                r --;
                continue;
            }

            if (chars[l] == chars[r]) {
                l ++;
                r --;
            } else {
                return false;
            }
        }
        return true;
    }
}
