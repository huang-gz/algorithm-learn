package org.hgz.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueueBetter {
        List<List<String>> res = new ArrayList<>();

        boolean[] st = null;
        boolean[] dg = null;
        boolean[] udg = null;
        char[][] g = null;
        int k = 0;

        public List<List<String>> solveNQueens(int n) {
            k = n;
            g = new char[n][n];
            for(char[] i : g){
                Arrays.fill(i,'.');
            }
            st = new boolean[n];
            dg = new boolean[2 * n];
            udg = new boolean[2 * n];
            dfs(0);
            return res;
        }

        public void dfs(int u){
            if(u == k){
                List<String> s = new ArrayList<>();
                for(char[] cs : g){
                    s.add(new String(cs));
                }
                res.add(s);
                return;
            }

            for(int i = 0; i < k; i++){
                if(!st[i] && !dg[i + u] && !udg[i - u + k]){
                    st[i] = dg[i + u] = udg[i - u + k] = true;
                    g[u][i] = 'Q';
                    dfs(u + 1);
                    g[u][i] = '.';
                    st[i] = dg[i + u] = udg[i - u + k] = false;
                }
            }
        }


}
