package org.hgz.algorithm.recursion;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-queens/
 *  N 皇后问题, 分治
 *  回溯思路
 *
 *  左右对角线  一个是 行 - 列  一个是 行 + 列
 *
 *  */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘, 放入.

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, result);
        return result;
    }

    /**
     * 递归
     */
    public void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }


        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                // 重置现场
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                    return false;
                }
            }
        }

        return true;
    }


    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    public static void main(String[] args) {

        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> lists = solveNQueens.solveNQueens(8);


        for (int i = 0; i < lists.size(); i++) {

            System.out.println(JSON.toJSONString(lists.get(i)));

        }

    }



}
