package org.hgz.algorithm.recursion;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> stringlist=new ArrayList<>();
        recur(0,0, n, "", stringlist);

        return stringlist;

    }

    private void recur(int left, int right, int n, String s, List<String> resultList) {
        //terminator
        if (left == n && right == n) {
//            System.out.println(s);
            resultList.add(s);
            return;
        }
        // process 当亲层逻辑
        if (left < n) {

            recur(left + 1, right, n, s + "(", resultList);
        }

        if (left > right) {
            recur(left, right  + 1, n, s + ")", resultList);
        }

    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);


        System.out.println(JSON.toJSONString(strings));
    }


}
