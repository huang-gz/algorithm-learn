package org.hgz.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {


    public static void main(String[] args) {
        char[][] chars = new char[5][5];

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (i == 1) {
                    chars[i][j]  = '.';
                    continue;
                }
                if (i == 2) {
                    chars[i][j]  = 'X';
                } else {
                    chars[i][j] = '*';
                }

            }
        }


        List<String> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            list.add(new String(chars[i]));
        }


        System.out.println(JSON.toJSONString(list));







    }
}
