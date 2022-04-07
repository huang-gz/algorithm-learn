package org.hgz.algorithm.dp;

import com.sun.xml.internal.fastinfoset.algorithm.FloatEncodingAlgorithm;

/**
 * @author guozhong.huang
 * 最长回文子串
 * DP 动态规划获取最长回文串 不是子序列
 */
public class LongestPalindrome {

    // 这么做回文串错误
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String s0 = s;

        int[][] op = new int[s.length()][s.length()];
        int maxIndex = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s0.charAt(i) == s0.charAt(j)) {
                    if (i == 0 || j == s.length() - 1) {
                        op[i][j] = 1;
                    } else {
                        op[i][j] = op[i - 1][j + 1] + 1;
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
        if (maxLength >= 1) {
            return s0.substring(maxIndex - maxLength + 1, maxIndex + 1);
        }
        return "";
    }


    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLength = 1;
        int index = 0;
        boolean[][] dp = new boolean[length][length];
        char[] chars = s.toCharArray();


        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int j = i + L - 1;
                if (j >= length) {
                    break;
                }

                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (L <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && L > maxLength) {
                    index = i;
                    maxLength = L;
                }
            }
        }
        return s.substring(index, index + maxLength);

    }


    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {

        int end = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expend(s, i, i);
            int len2 = expend(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);


    }

    public int expend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 前 ++ , 这个要注意
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String abac = longestPalindrome.longestPalindrome2("bbcb");
        System.out.println(abac);
    }
}

