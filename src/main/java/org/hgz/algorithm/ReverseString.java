package org.hgz.algorithm;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import org.hgz.algorithm.utils.SwapUtil;

public class ReverseString {

    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length -1;

        while(l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
