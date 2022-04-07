package org.hgz.algorithm.recursion;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 * 子问题 分支回溯
 */
public class LetterCombinations {


    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = buildPhoneMap();


        recur(digits, 0, phoneMap, "", combinations);
        return combinations;

    }

    private void recur(String digits, int level, Map<Character, String> phoneMap, String s, List<String> combinations) {
        if (level == digits.length()) {
            combinations.add(s);
            return;
        }
        char c = digits.charAt(level);
        String s1 = phoneMap.get(c);

        for (int i = 0; i < s1.length(); i++) {
            recur(digits, level+1, phoneMap, s + String.valueOf(s1.charAt(i)), combinations);
        }


    }




    private Map<Character, String> buildPhoneMap() {
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        return phoneMap;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        System.out.println(JSON.toJSONString(strings));
    }


}
