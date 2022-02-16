package org.hgz.algorithm;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {


    public static void main(String[] args) {
        String str ="中华人民共和国，简称(中国)。";

        Matcher matcher = Pattern.compile("(?<=\\()(\\S+)(?=\\))").matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }


    }
}
