package org.hgz.algorithm;



public class ReverseVowels {

    public static String reverseVowels(String s) {

        char[] chars = s.toCharArray();

        int l = 0;
        int r = chars.length - 1;

        while (l < r) {

            if (!isVowel(chars[l])) {
                l ++;
                continue;
            }

            if (!isVowel(chars[r])) {
                r --;
                continue;
            }

            if (isVowel(chars[l]) && isVowel(chars[r])) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l ++;
                r --;
            }
        }
        return new String(chars);

    }


    private static boolean isVowel(char c) {

        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' || c == 'A' ||
                c == 'O' || c == 'E' || c == 'I' || c == 'U';


    }

    public static void main(String[] args) {
        String param = "hello";

        String s = reverseVowels(param);
        System.out.println(s);
    }

}
