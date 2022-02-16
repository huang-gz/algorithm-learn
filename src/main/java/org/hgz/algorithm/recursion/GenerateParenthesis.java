package org.hgz.algorithm.recursion;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    List<String> result = null;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList();

        recur(0, 0, n, "");
        return result;
    }

    private void recur(int left, int right, int n, String a) {
        if (left == n && right == n) {
            result.add(a);
            return;
        }
        if (left < n) {
            recur(left + 1, right, n, a + "(");
        }
        if (right < left) {
            recur(left, right + 1, n, a + ")");
        }


    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);


        System.out.println(JSON.toJSONString(strings));
    }


}
