package org.hgz.algorithm.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/n-queens-ii
 */
public class TotalNQueens {



    Set<Integer> column = new HashSet<>();

    Set<Integer> pie = new HashSet<>();

    Set<Integer> na = new HashSet<>();

    public int totalNQueens(int n){
        if (n < 1) {
            return 0;
        }

        List<String> resultList = new ArrayList<>();
        dfs(0, n, resultList);
        return resultList.size();
    }

    public void dfs(int row, int n, List<String> resultList) {
        if (row == n) {
            resultList.add("1");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!column.contains(i) && ! pie.contains(row - i) && !na.contains(row + i)) {
                column.add(i);
                pie.add(row -i );
                na.add(row + i);
                dfs(row + 1, n, resultList);

                column.remove(i);
                pie.remove(row-i);
                na.remove(row + i);
            }
        }
    }

    public static void main(String[] args) {
        TotalNQueens totalNQueens  = new TotalNQueens();
        int i = totalNQueens.totalNQueens(4);
        System.out.println(i);
    }
}
