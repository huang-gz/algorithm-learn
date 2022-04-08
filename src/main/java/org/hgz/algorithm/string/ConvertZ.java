package org.hgz.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guozhong.huang
 */
public class ConvertZ {


    public String convert(String s, int numRows) {

        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            result.add(new StringBuilder());
        }


        int i = 0;
        int flag = -1;

        for (char c : s.toCharArray()) {
            result.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder s1 = new StringBuilder();

        for (int j = 0; j < numRows; j++) {
            s1.append(result.get(j));
        }
        return s1.toString();
    }

    public static void main(String[] args) {
        ConvertZ convertZ = new ConvertZ();
        String a = "AB";
        System.out.println(a);
        String paypalishiring = convertZ.convert(a, 1);
        System.out.println(paypalishiring);
    }
}
