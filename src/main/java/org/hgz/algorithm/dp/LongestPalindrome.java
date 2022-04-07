package org.hgz.algorithm.dp;

/**
 * @author guozhong.huang
 * 最长回文子串
 * DP 动态规划获取最长回文串 不是子序列
 */
public class LongestPalindrome {


    public String longestPalindrome(String s) {
        String s0 = s;

        int[][] op = new int[s.length()][s.length()];
        int maxIndex = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() -1 ; j >=0; j--) {
                if (s0.charAt(i) == s0.charAt(j)) {
                    if (i == 0 || j == s.length() - 1) {
                        op[i][j] = 1;
                    } else {
                        op[i][j] =  op[i-1][j+1] + 1;
                    }
                    if (op[i][j] > maxLength) {
                        maxLength = op[i][j];
                        maxIndex = i;
                    }
                } else {
                    op[i][j] = 0;
                }
            }
        }
        if (maxLength >= 2) {
            return s0.substring(maxIndex - maxLength + 1, maxIndex + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String abac = longestPalindrome.longestPalindrome("abbc");
        System.out.println(abac);
    }
}

