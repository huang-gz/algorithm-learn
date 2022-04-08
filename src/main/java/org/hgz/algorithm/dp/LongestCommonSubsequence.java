package org.hgz.algorithm.dp;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int columnLength = text1.length();
        int rowLength = text2.length();


        // 初始化定义一个数组
        int[][] op = new int[rowLength][columnLength];
        // 初始化最后一个字符情况

        boolean rowContain = false;
        for (int i = columnLength - 1; i >= 0; i--) {
            if (text1.charAt(i) == text2.charAt(rowLength - 1) || rowContain) {
                op[rowLength - 1][i] = 1;
                rowContain = true;
            } else {
                op[rowLength - 1][i] = 0;
            }
        }

        boolean columnContain = false;
        for (int i = rowLength - 1; i >= 0; i--) {
            if (text1.charAt(columnLength - 1) == text2.charAt(i) || columnContain) {
                op[i][columnLength - 1] = 1;
                columnContain = true;
            } else {
                op[i][columnLength - 1] = 0;
            }
        }


        for (int i = rowLength - 2; i >= 0; i--) {
            for (int j = columnLength - 2; j >= 0; j--) {
                if (text1.charAt(j) == text2.charAt(i)) {
                    op[i][j] = op[i + 1][j + 1] + 1;
                } else {
                    op[i][j] = Math.max(op[i][j + 1], op[i + 1][j]);
                }
            }
        }
        return op[0][0];
    }


    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

        String text1 = "abcde", text2 = "ace";

        int i = longestCommonSubsequence.longestCommonSubsequence(text1, text2);

        System.out.println(i);
    }

    public int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
