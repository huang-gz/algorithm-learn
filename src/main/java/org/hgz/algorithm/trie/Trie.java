package org.hgz.algorithm.trie;


/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class Trie {

    Trie[] child;
    boolean isEnd;

    public Trie() {
        child = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        return trie != null;

    }

    private Trie searchPrefix(String prefix) {

        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                return null;
            }
            node = node.child[index];
        }
        return node;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("abc");
        trie.insert("abcd");

        Trie trie1 = trie.searchPrefix("abc");

        boolean abc = trie.search("abc");


    }
}
