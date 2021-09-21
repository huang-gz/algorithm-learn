package org.hgz.algorithm.string;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >=0 ; i--) {
            if (s.charAt(i) == ' ') {
                if (j > 0) {
                    return j;
                }
            } else {
                j++;
            }
        }
        return j;
    }


    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";

        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int result = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println(result);



    }

}
