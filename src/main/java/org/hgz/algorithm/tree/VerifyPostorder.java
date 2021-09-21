package org.hgz.algorithm.tree;

/**
 * 验证二叉树是否是后续遍历
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length -1);
    }

    private boolean recur(int[] postorder, int i, int j) {

        if (i > j) {
            return true;
        }

        int p = i;
        while (postorder[p] < postorder[j] ){
                p++;
        }
        int m = p;

        while (postorder[p] > postorder[j]) {
            p++;
        }

        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
